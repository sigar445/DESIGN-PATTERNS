package org.sigar.NIO_InOut;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;
import java.nio.ByteBuffer;

public class NioUdpServer{

public static void main(String[] args) throws IOException {
    int port = 8080; // Replace with your desired port

    // Create a DatagramChannel
    DatagramChannel channel = DatagramChannel.open();
    channel.configureBlocking(false); // Set non-blocking mode

    // Bind the channel to the specified port
    channel.bind(new  InetSocketAddress("localhost", port));

    // Create a selector to monitor the channel for events
    Selector selector = Selector.open();
    channel.register(selector, SelectionKey.OP_READ);

    System.out.println("UDP server listening on port " + port);

    while (true) {
        // Wait for events
        selector.select();

        // Get the selected keys
        Set<SelectionKey> selectedKeys = selector.selectedKeys();
        Iterator<SelectionKey> iter = selectedKeys.iterator();

        while (iter.hasNext()) {
            SelectionKey key = iter.next();
            iter.remove();


            if (key.isReadable()) {
                // Read data from the channel
//                ByteBuffer buffer = ByteBuffer.allocate(1024);
//                channel.read(buffer);
//                buffer.flip();
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                SocketAddress clientAddress = channel.receive(buffer); // get client address
                buffer.flip();

                // Process the received data (e.g., print it)
                String data = new String(buffer.array()).trim();
                System.out.println("Received data: " + data);

                // Send a response (optional)
                ByteBuffer responseBuffer = ByteBuffer.wrap("Received your message.Hello yourself from the server".getBytes());
                channel.send(responseBuffer, clientAddress); // send response to client
            }
        }
    }
}
}