import java.io.*;
import java.net.*;

public class SocketLoop {

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket ss = new ServerSocket(30000);
        Socket s = new Socket("localhost", 30000);

        Socket client = ss.accept();
        System.out.println("Connection accepted!");

        System.out.println("Server: Writing int 5 to the accepted connection...");
        client.getOutputStream().write(5);

        InputStream in = s.getInputStream();
        while (in.available() != 0) {
            int received = in.read();
            System.out.println("Client: Received " + received);

        }
    }
}