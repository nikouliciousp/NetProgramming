package gr.perisnik.daytime;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * DayTimeServer is a simple server program that listens for incoming connections
 * on port 13 and responds with the current date and time.
 *
 * The server accepts connections from clients, sends the current date and time,
 * and then closes the connection.
 *
 * @version 0.1
 * @author Peris Nik
 */
public class DayTimeLocalServer extends Thread {
    // Server socket to listen for connections
    private static ServerSocket serverFD;

    // Flag to control the server loop
    private boolean running = true;

    /**
     * The run method starts the server, listens for incoming connections,
     * and responds with the current date and time.
     *
     */
    @Override
    public void run() {
        try {
            // Create a server socket
            serverFD = new ServerSocket();
            // Port number to listen on
            int serverPort = 13;

            // Bind the server socket to the specified address and port, with a backlog of 100
            serverFD.bind(new InetSocketAddress("127.0.0.1", serverPort), 100);

            // Loop to accept and handle incoming connections while running is true
            while (running) {
                // Accept an incoming connection
                Socket connectedFD = serverFD.accept();
                // Create a BufferedWriter to send data to the connected client
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(connectedFD.getOutputStream()));

                // Write the current date and time to the client
                bufferedWriter.write("" + new Date());
                // Flush the writer to ensure all data is sent
                bufferedWriter.flush();
                // Close the BufferedWriter
                bufferedWriter.close();
                // Close the connection with the client
                connectedFD.close();
            }
        } catch (IOException e) {
            // Print the stack trace if an IOException occurs
            e.printStackTrace();
        } finally {
            // Ensure the server socket is closed properly
            if (serverFD != null && !serverFD.isClosed()) {
                try {
                    serverFD.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Main method to run the DayTimeServer.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create and start the DayTimeServer thread
        DayTimeLocalServer server = new DayTimeLocalServer();
        server.start();

        // Add shutdown hook to stop the server gracefully
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.stopServer();
            System.out.println("DayTimeServer has been stopped.");
        }));

        System.out.println("DayTimeServer is running...");
    }

    /**
     * Method to stop the server loop.
     */
    public void stopServer() {
        running = false;
        if (serverFD != null && !serverFD.isClosed()) {
            try {
                serverFD.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
