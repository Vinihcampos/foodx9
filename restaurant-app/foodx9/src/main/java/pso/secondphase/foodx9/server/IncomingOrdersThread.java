package pso.secondphase.foodx9.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pso.secondphase.iox9.configuration.ApplicationConfiguration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vitorgreati
 */
public class IncomingOrdersThread extends Thread {
    
    private volatile Queue<String> incomingOrdersQueue;
    
    private DatagramSocket socketServer;
    
    private volatile boolean active;
    
    private static IncomingOrdersThread instance;
    
    public static IncomingOrdersThread getInstance() {
        if (instance == null)
            instance = new IncomingOrdersThread();
        return instance;
    }
    
    private IncomingOrdersThread() {
        incomingOrdersQueue = new LinkedList<>();
    }
    
    @Override
    public synchronized void run() {
        
        this.setActive(true);
        
        while (isActive()) {
            
            try {
                if (socketServer != null && !socketServer.isClosed()) {
                    System.out.println("Waiting for an incoming order...");
                    
                    byte[] msg = new byte[256];
                    
                    DatagramPacket pkg = new DatagramPacket(msg, msg.length);
                    
                    socketServer.receive(pkg);

                    String message = new String(pkg.getData());
                    System.out.println("An order has come: " + message);
                    getIncomingOrdersQueue().add(message);
                } else {
                    socketServer = new DatagramSocket(null);
                    InetSocketAddress ia = new InetSocketAddress(
                            (String) ApplicationConfiguration.getInstance().getParameters().get("server_ip"),
                            (Integer) ApplicationConfiguration.getInstance().getParameters().get("server_port_in"));
                    socketServer.bind(ia);
                }  
            }catch (IOException ex) {
                Logger.getLogger(IncomingOrdersThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the incomingOrdersQueue
     */
    public synchronized Queue<String> getIncomingOrdersQueue() {
        return incomingOrdersQueue;
    }

    /**
     * @param incomingOrdersQueue the incomingOrdersQueue to set
     */
    public synchronized void setIncomingOrdersQueue(Queue<String> incomingOrdersQueue) {
        this.incomingOrdersQueue = incomingOrdersQueue;
    }
    

}
