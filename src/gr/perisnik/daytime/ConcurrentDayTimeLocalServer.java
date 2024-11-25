package gr.perisnik.daytime;

        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.OutputStreamWriter;
        import java.net.InetSocketAddress;
        import java.net.ServerSocket;
        import java.net.Socket;
        import java.util.Date;

/**
 * ConcurrentDayTimeServer is a simple server program that listens for incoming connections
 * on port 13 and responds with the current date and time.
 * Each client connection is handled in a separate thread.
 *
 * @version 0.1
 * @author Peris Nik
 */
public class ConcurrentDayTimeLocalServer extends Thread {
    // Server socket to listen for connections
    private ServerSocket serverFD;

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

            System.out.println("ConcurrentDayTimeServer is running...");

            // Loop to accept and handle incoming connections while running is true
            while (running) {
                // Accept an incoming connection
                Socket connectedFD = serverFD.accept();
                // Create a new thread to handle the client connection
                new ClientHandler(connectedFD).start();
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

    /**
     * ClientHandler is a thread that handles a single client connection.
     */
    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        /**
         * Constructor for ClientHandler.
         *
         * @param socket The client socket
         */
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Create a BufferedWriter to send data to the connected client
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                // Write the current date and time to the client
                bufferedWriter.write("Local Server says: " + new Date());
                // Flush the writer to ensure all data is sent
                bufferedWriter.flush();
                // Close the BufferedWriter
                bufferedWriter.close();
                // Close the connection with the client
                clientSocket.close();
            } catch (IOException e) {
                // Print the stack trace if an IOException occurs
                e.printStackTrace();
            }
        }
    }

    /**
     * Main method to run the ConcurrentDayTimeServer.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create and start the ConcurrentDayTimeServer thread
        ConcurrentDayTimeLocalServer server = new ConcurrentDayTimeLocalServer();
        server.start();

        // Add shutdown hook to stop the server gracefully
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.stopServer();
            System.out.println("ConcurrentDayTimeServer has been stopped.");
        }));

        System.out.println("ConcurrentDayTimeServer is running...");
    }
}
