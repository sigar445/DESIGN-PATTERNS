package org.sigar.CustomStreams;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UpperCaseFIS extends FilterInputStream {
    /**
     * Creates a {@code FilterInputStream}
     * by assigning the  argument {@code in}
     * to the field {@code this.in} so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or {@code null} if
     *           this instance is to be created without an underlying stream.
     */
    protected UpperCaseFIS(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        // Read a single byte
        int c = super.read();

        // If it's not the end of the stream, convert it to uppercase
        return (c == -1) ? c : Character.toUpperCase((char) c);
    }

    @Override
    public int read(byte[] b,int off,int len) throws IOException{
        int result = super.read(b,off,len);
        for (int i = off; i < off + result; i++) {
            b[i] = (byte) Character.toUpperCase((char) b[i]);
        }
        return result;
    }

}
