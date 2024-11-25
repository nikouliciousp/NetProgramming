package gr.perisnik.daytime;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.net.InetAddress;
        import java.net.Socket;

/**
 * DayTimeClient is a simple Java program that connects to a local DayTime server
 * running on port 13 and retrieves the current time and date from the server.
 *
 * The program connects to the server at '127.0.0.1' on port 13, reads the
 * server's response, and prints the time and date to the console.
 *
 * @version 0.1
 * @author Peris Nik
 */
public class DayTimeClientForLocalServer {

    /**
     * Main method to run the DayTimeClient.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // StringBuilder to accumulate the server's response
        StringBuilder stringBuilder = new StringBuilder();

        try {
            // Resolve the server address from the hostname '127.0.0.1'
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            // Define the port number to connect to on the server
            int serverPort = 13;

            // Create a socket and connect to the server at the resolved address and port
            Socket socketFD = new Socket(serverAddress, serverPort);

            // Create a BufferedReader to read the server's response from the socket's input stream
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socketFD.getInputStream()));

            String line;

            // Read the server's response line by line and append it to the StringBuilder
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            // Print the server's response to the console
            System.out.println("Daytime from local Server says: " + stringBuilder.toString());

            // Close the socket connection
            socketFD.close();
        } catch (IOException e) {
            // Print the stack trace if an IOException occurs
            e.printStackTrace();
        }
    }
}
