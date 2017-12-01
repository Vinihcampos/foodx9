package pso.secondphase.foodx9.client;

import android.util.Log;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by vinihcampos on 26/06/17.
 */

public class TCPconnection {
    private static Socket socket;
    private static PrintWriter out;
    private static Boolean isConnected = false;

    public TCPconnection(int port, String ip) throws IOException {
        socket = new Socket(ip, port);
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }

    public static void sendMsg(String msg) throws IOException {

        // Initialize output stream to write message to the socket stream
        //out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        // Write message to stream
        out.println(msg);

        // Flush the data from the stream to indicate end of message
        out.flush();

        Log.i("TESTING",  msg);
        // Close the output stream
        //out.close();
    }

    public static void closeConnection() throws IOException {
        socket.close();
    }

    public static Boolean getIsConnected() {
        return isConnected;
    }

    public static void setIsConnected(Boolean isConnected) {
        TCPconnection.isConnected = isConnected;
    }
}
