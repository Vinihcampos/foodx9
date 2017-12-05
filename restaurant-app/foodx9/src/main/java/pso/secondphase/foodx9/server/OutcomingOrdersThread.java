package pso.secondphase.foodx9.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pso.secondphase.foodx9.util.InMemoryFoodDatabase;
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
public class OutcomingOrdersThread extends Thread {
    
    private volatile Queue<String> outcomingOrdersQueue;
    
    private DatagramSocket socketServer;
    
    private volatile boolean active;
    
    private static OutcomingOrdersThread instance;
    
    public static OutcomingOrdersThread getInstance() {
        if (instance == null)
            instance = new OutcomingOrdersThread();
        return instance;
    }
    
    private OutcomingOrdersThread() {
        outcomingOrdersQueue = new LinkedList<>();
        
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                socketServer.close(); /* failed */
                System.out.println("The server is shut down!");
            }
        });
    }
    
    @Override
    public synchronized void run() {
        
        this.setActive(true);
        
        while (isActive()) {        
            
            try {
                if(!InMemoryFoodDatabase.getInsideFoods().isEmpty()){
                    int pos = (int)(Math.random() * InMemoryFoodDatabase.getInsideFoods().size());
                    getOutcomingOrdersQueue().add(InMemoryFoodDatabase.getInsideFoods().get(pos));
                    InMemoryFoodDatabase.getInsideFoods().remove(pos);
                }
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OutcomingOrdersThread.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                /*try {
                if (socketServer != null && !socketServer.isClosed()) {
                System.out.println("Waiting for an outcoming order...");
                
                byte[] msg = new byte[256];
                
                DatagramPacket pkg = new DatagramPacket(msg, msg.length);
                
                socketServer.receive(pkg);
                
                String message = new String(pkg.getData());
                System.out.println("An order has finished: " + message);
                getOutcomingOrdersQueue().add(message);
                } else {
                socketServer = new DatagramSocket(null);
                InetSocketAddress ia = new InetSocketAddress(
                (String) ApplicationConfiguration.getInstance().getParameters().get("server_ip"),
                (Integer) ApplicationConfiguration.getInstance().getParameters().get("server_port_out"));
                socketServer.bind(ia);
                }
                }catch (IOException ex) {
                Logger.getLogger(OutcomingOrdersThread.class.getName()).log(Level.SEVERE, null, ex);
                }*/
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
     * @return the outcomingOrdersQueue
     */
    public synchronized Queue<String> getOutcomingOrdersQueue() {
        return outcomingOrdersQueue;
    }

    /**
     * @param outcomingOrdersQueue the outcomingOrdersQueue to set
     */
    public synchronized void setOutcomingOrdersQueue(Queue<String> outcomingOrdersQueue) {
        this.outcomingOrdersQueue = outcomingOrdersQueue;
    }
    

}
