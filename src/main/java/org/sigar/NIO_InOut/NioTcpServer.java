package org.sigar.NIO_InOut;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioTcpServer {
    public static void main(String[] args) throws IOException {
        // Step 1: Open a selector
        try (Selector selector = Selector.open();
             ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
             ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open()) {

            // Configure both server channels for non-blocking mode
            serverSocketChannel1.configureBlocking(false);
            serverSocketChannel2.configureBlocking(false);

            // Bind the server channels to different ports (8080 and 8082)
            serverSocketChannel1.bind(new InetSocketAddress(8081));
            serverSocketChannel2.bind(new InetSocketAddress(8082));

            // Register both server channels with the selector for accepting new connections
            serverSocketChannel1.register(selector, SelectionKey.OP_ACCEPT);
            serverSocketChannel2.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Server started and listening on port 80801/82...");
        while (true) {
            // Step 5: Wait for events (client connections, reads, writes, etc.)
            selector.select(); // This blocks until at least one event occurs

            // Step 6: Get the selected keys and process them
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                keyIterator.remove();

                if (key.isAcceptable()) {
                    // Accept a new client connection
                    ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                    SocketChannel clientChannel = serverChannel.accept();
                    clientChannel.configureBlocking(false);

                    // Register the new client channel with the selector for reading
                    clientChannel.register(selector, SelectionKey.OP_READ);

                    System.out.println("Accepted new client connection: " + clientChannel.getRemoteAddress());

                } else if (key.isReadable()) {
                    // Read data from a client
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    try{
                        int bytesRead = clientChannel.read(buffer);
                        if (bytesRead == -1) {
                            // Client has closed the connection
                            System.out.println("Client disconnected: " + clientChannel.getRemoteAddress());
                            clientChannel.close();
                        } else if (bytesRead > 0) {
                            // Process the incoming data
                            buffer.flip();
                            byte[] data = new byte[buffer.limit()];
                            buffer.get(data);
                            System.out.println("Received message: " + new String(data));

                            // Echo the message back to the client
                           // buffer.rewind(); // Rewind buffer for writing back
                            ByteBuffer responseBuffer = ByteBuffer.allocate(256);
                            responseBuffer.put("Hello, Client!".getBytes());
                            responseBuffer.flip();

                            clientChannel.write(responseBuffer);
                        }
                    } catch (IOException e) {
                            System.out.println("Connection reset by client.");
                            clientChannel.close(); // Close the channel if there's an exception
                            break; // Exit the loop or method
                        }

                    }
                }
            }
        }
       }
    }

