package pso.secondphase.foodx9.client;

import android.os.StrictMode;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by vinihcampos on 23/06/17.
 */

public class UDPconnection {

    private static DatagramSocket client_socket;
    private static InetAddress IPAddress;
    private static int port;


    public UDPconnection(int port, String ip) throws SocketException, UnknownHostException {
        this.client_socket = new DatagramSocket(port);
        this.IPAddress = InetAddress.getByName(ip);
        this.port = port;
    }

    public static void sendMsg(String msg) throws IOException {
        byte[] send_data = new byte[1024];
        send_data = msg.getBytes("utf-8");
        //System.out.println("Type Something (q or Q to quit): ");

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        DatagramPacket send_packet = new DatagramPacket(msg.getBytes("utf-8"),msg.length(), IPAddress, port);
        client_socket.send(send_packet);
    }

}
