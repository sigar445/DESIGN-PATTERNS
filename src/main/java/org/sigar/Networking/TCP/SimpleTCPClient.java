package org.sigar.Networking.TCP;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleTCPClient {

    static public void startClient(){
        String hostName = "localhost";
        int port = 1234;

        try(Socket socket = new Socket(hostName,port)){

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while (true) {
                System.out.print("Enter message: ");
                message = consoleInput.readLine();  // Read from console

                output.println(message);  // Send to server
                System.out.println("Server response: " + input.readLine());  // Read response

                if ("bye".equalsIgnoreCase(message)) {
                    break;
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        startClient();
    }
}
