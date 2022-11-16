// Adopted from Core Java: Fundamentals Volume 2, by Cay Horstmann

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;

public class SocketExample {

    public static void main(String[] args) throws IOException {

        // The following Socket constructor takes two arguments:
        // The URL and the port number to attempt to connect to.

        try (Socket s = new Socket("time-a.nist.gov", 13)) {
            // Note that you receive data over the socket through its input stream!
            // You get a reference to this by calling s.getInputStream().
            var in = new Scanner(s.getInputStream(), StandardCharsets.UTF_8);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}