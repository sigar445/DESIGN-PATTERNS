package org.sigar.NIO_InOut;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NioFileChannel {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("Nio.txt");

        try(FileChannel channel = FileChannel.open(path,StandardOpenOption.WRITE, StandardOpenOption.CREATE)){
            ByteBuffer buffer = ByteBuffer.allocate(64);
            buffer.put("Hello from FileChannel".getBytes());
            buffer.flip();
            channel.write(buffer);
        }

        try (FileChannel channel = FileChannel.open(path,StandardOpenOption.READ)){

            ByteBuffer buffer = ByteBuffer.allocate(64);
            channel.read(buffer);
            buffer.flip();
            System.out.println("Data " + new String(buffer.array()).trim());
      }
    }
}
