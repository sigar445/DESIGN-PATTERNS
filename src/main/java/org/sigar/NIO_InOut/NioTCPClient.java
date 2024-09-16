package org.sigar.NIO_InOut;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioTCPClient {
    public static void main(String[] args) throws IOException {
        // Open a socket channel
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 8080));
        socketChannel.configureBlocking(false);

        // Send a message to the server
        ByteBuffer buffer = ByteBuffer.allocate(256);
        buffer.put("Hello, Server!".getBytes());
        buffer.flip();
        socketChannel.write(buffer);

        // Read the response from the server
        // Wait to read the response from the server
        buffer.clear();
        while (socketChannel.read(buffer) <= 0) {
            // Keep reading until response is received
        }
        buffer.flip();
        System.out.println("Server Response: " + new String(buffer.array(), 0, buffer.limit()));

        // Properly close the socket
        socketChannel.close();
    }
}
