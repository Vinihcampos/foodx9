
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
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
    
    private ServerSocket socketServer;
    
    private volatile boolean active;
    
    private static IncomingOrdersThread instance;
    
    public static IncomingOrdersThread getInstance() {
        if (instance == null)
            instance = new IncomingOrdersThread();
        return instance;
    }
    
    private IncomingOrdersThread() {}
    
    @Override
    public void run() {
        
        this.setActive(true);
        
        while (isActive()) {
            try {
                if (socketServer != null && !socketServer.isClosed()) {
                    Socket client = socketServer.accept();

                    Scanner scanner = new Scanner(client.getInputStream());
                    getIncomingOrdersQueue().add(scanner.next());
                } else {
                    socketServer = new ServerSocket();
                    socketServer.bind(new InetSocketAddress(
                            (String) ApplicationConfiguration.getInstance().getParameters().get("server_ip"), 
                            (Integer) ApplicationConfiguration.getInstance().getParameters().get("server_port")
                    ));
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
