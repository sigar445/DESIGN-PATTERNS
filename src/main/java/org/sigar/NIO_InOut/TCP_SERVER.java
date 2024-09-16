package org.sigar.NIO_InOut;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_SERVER {


        public static void main(String[] args) throws IOException {
            // Server port
            int port = 8080;

            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("Server started on port " + port);

                // Wait for a client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Handle communication with the client (simplified example)
                // You can read/write data to/from the clientSocket here
                clientSocket.getInputStream().close();
                clientSocket.getOutputStream().close();
            }
        }
    }

