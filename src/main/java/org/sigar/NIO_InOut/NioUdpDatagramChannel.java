package org.sigar.NIO_InOut;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class NioUdpDatagramChannel {
    public static void main(String[] args) throws Exception {
        DatagramChannel datagramChannel = DatagramChannel.open();

        // Bind the DatagramChannel to a local port
        datagramChannel.bind(new InetSocketAddress(9999));

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        buffer.put("Hello via UDP".getBytes());
        buffer.flip();

        // Send a packet
        datagramChannel.send(buffer, new InetSocketAddress("localhost", 8080));

        // Receive a packet
        buffer.clear();
        datagramChannel.receive(buffer);
        buffer.flip();
        System.out.println("Received: " + new String(buffer.array(), 0, buffer.limit()));
    }
}
