import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.spec.RSAOtherPrimeInfo;

public class CalculatorClient {

    public static void main(String[] args) throws IOException {

        // Overwrite the args received.
        // If you'd like to pass in your own args, comment out the following line.
        // args = new String[]{"localhost","50000"};

        if (args.length != 2) {
            System.err.println(
                    "Usage: java CalculatorClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        // Big try-with-resources block
        try (
                var clientSocket = new Socket(hostName, portNumber);        // client
                var out = new PrintWriter(clientSocket.getOutputStream(), true);    // Client OutputStream
                var in = new BufferedReader(                                                    // reads from inputstream
                                new InputStreamReader(clientSocket.getInputStream()));
                var stdIn = new BufferedReader(                                             // reads from keyboard
                                new InputStreamReader(System.in))
        ) {
            System.out.println("Client: Connected to server!");
            System.out.println(in.readLine());

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println(in.readLine());
            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }

}
