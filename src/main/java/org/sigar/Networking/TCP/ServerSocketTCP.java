package org.sigar.Networking.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTCP {

    public static void startTCPServer() throws IOException {

        int port = 1234;
        try(ServerSocket server = new ServerSocket(port)){
            System.out.println("Server is listening on port " + port);


            Socket client = server.accept();
            System.out.println("New Client Connected");

            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter output = new PrintWriter(client.getOutputStream(),true);

            String message;
            while ((message = input.readLine()) != null) {
                System.out.println("Received: " + message);

                // Send response to the client
                output.println("Echo: " + message);

                // Break if the client says "bye"
                if ("bye".equalsIgnoreCase(message)) {
                    break;
                }
            }

            client.close();
            System.out.println("Client disconnected");
        } catch (IOException e) {
            System.err.println("Error in the server: " + e.getMessage());
        }



        }

    public static void main(String[] args) throws IOException {
        startTCPServer();
    }

}
