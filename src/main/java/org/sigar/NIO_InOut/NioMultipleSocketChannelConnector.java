package org.sigar.NIO_InOut;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioMultipleSocketChannelConnector {
    public static void main(String[] args) throws IOException {
        try(Selector selector = Selector.open();
            SocketChannel socketChannel1 = SocketChannel.open();
            SocketChannel socketChannel2 = SocketChannel.open()){

        // Open and configure first SocketChannel
        socketChannel1.configureBlocking(false);
        socketChannel1.connect(new InetSocketAddress("localhost", 8081));
        socketChannel1.register(selector, SelectionKey.OP_CONNECT);

        // Open and configure second SocketChannel
        socketChannel2.configureBlocking(false);
        socketChannel2.connect(new InetSocketAddress("localhost", 8082));
        socketChannel2.register(selector, SelectionKey.OP_CONNECT);

        while (true) {
            selector.select();

            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iter = selectedKeys.iterator();

            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                iter.remove();

                if (key.isConnectable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    if (channel.isConnectionPending()) {
                        channel.finishConnect();
                    }
                    channel.register(selector, SelectionKey.OP_READ);

                    // Send a message to server
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    buffer.put("Hello Server!".getBytes());
                    buffer.flip();
                    channel.write(buffer);
                } else if (key.isReadable()) {
                    // Read data from server
                    System.out.println("Reading response from the server");
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);

                    try {
                        int bytesRead = channel.read(buffer);
                        if (bytesRead == -1) {
                            // Server closed the connection
                            System.out.println("Server closed the connection.");
                            channel.close();
                            return; // Exit the loop or method
                        }

                        buffer.flip(); // Prepare buffer for reading
                        String response = new String(buffer.array(), 0, buffer.limit()).trim();
                        System.out.println("Server Response: " + response);
                    } catch (IOException e) {
                        System.out.println("Connection reset by server.");
                        channel.close(); // Close the channel if there's an exception
                        return; // Exit the loop or method
                    }
                }
            }
        }
        }
    }
}
