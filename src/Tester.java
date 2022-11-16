public class Tester {
}


/*

The goal: Create a client that sends simple arithmetic expressions, and a server that solves them and sends the result back to the client.
All classes must follow all good design and coding practices, including good design of classes, code indenting, appropriate comments, and readable and meaningful output.

Class design requirements:
Your program should contain at least the following classes (you're welcome to include any other classes you need):
    •    CalculatorClient
    •    CalculatorServer

Important note: This is an unusual project in that it does not requires a Tester class!  I will run your two classes myself, CalculatorClient and CalculatorServer, and test them.

Each of your classes, CalculatorClient and CalculatorServer, should have main(String[] args) methods, allowing them to be run!  Thus, they will never actually be instantiated; they will just run.

    Here are the requirements for each class:

CalculatorServer:
Creates a ServerSocket that awaits a connection on a port of your choice.
When a connection is made, sends a one-time welcome message to the connected socket.
Repeatedly awaits data from the connected socket in the form <double> <operator> <double>, where <double> is a string that can be parsed to a Java Double data type, and <operator> is a string that is either "+", "-", "/", or "*", representing addition, subtraction, division, or multiplication, respectively.
When data of this form is received, representing an arithmetic calculation to be made, actually does the calculation and send the result back to the connecting socket.


CalculatorClient:
Creates a Socket that connects to some port of your choice on the host "localhost".  This port should match that of the server!
Repeatedly asks the user for input, and sends that input over the socket connection to the server.
When a response is received (which should be the solution to the arithmetic problem), prints that to the console.


Note: It's okay in this case for your server or client to crash if the client sends data in the wrong format (for example, if the client sent the string "5+5" with no spaces, or the string "foo").  You will not be marked down for this occurring.

However, it would be a nice opportunity to practice defensive and robust programming by making your client and server fault-tolerant of bad data entered by the user of the client! So, if you have the time, try making your client and/or server handle the user typing in a bad request in the client console.

EXAMPLE:

Welcome to CalculatorServer 1.0!
Please enter a simple dyadic expression:
5 + 5
Result received: 10.0
Please enter a simple dyadic expression:
4.0 * 3.1
Result received: 12.4
Please enter a simple dyadic expression:
100 - 1.1
Result received: 98.9
Please enter a simple dyadic expression:
20.0 / 4
Result received: 5.0
Please enter a simple dyadic expression:


*/