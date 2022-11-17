import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: java CalculatorServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try (
                var serverSocket = new ServerSocket(Integer.parseInt(args[0])); // Server
                Socket clientSocket = serverSocket.accept();                    // Client
                var out = new PrintWriter(clientSocket.getOutputStream(), true);    // Prints to client
                var in = new BufferedReader(                                                 // reads from client inputstream
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {
            System.out.println("Server: established connection to client;");
            out.println("Welcome to the calculator server, client! Please enter <double> <operator> " +
            "<double>, separated by spaces...");
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                // divide input line by number, operator, number
                // for each loop inside string until an operator is hit
                // store operator
                // double operand1 = 0 until index of operand minus one
                // double operand2 = index of operand plus one until length of inputline

//                double operand1 = 0;
//                double operand2 = 0;
                double result = 0;

                for (int i = 0; i < inputLine.length(); i++) {

                    char currentChar = inputLine.charAt(i);
                    if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/' ||
                            currentChar == '%') {

                        double operand1 = Double.parseDouble(inputLine.substring(0, i - 1));
                        double operand2 = Double.parseDouble(inputLine.substring(i + 2));

                        switch (currentChar) {
                            case '+' -> result = operand1 + operand2;
                            case '-' -> result = operand1 - operand2;
                            case '*' -> result = operand1 * operand2;
                            case '/' -> result = operand1 / operand2;
                            case '%' -> result = operand1 % operand2;
                        }

                    }

                }

                out.println(result + "\n");
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }

    }
}
