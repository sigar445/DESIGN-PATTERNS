package org.sigar.CustomStreams;

import java.io.*;

public class UpperCaseFOS extends FilterOutputStream {
    public UpperCaseFOS(OutputStream outputStreamStream){
        super(outputStreamStream);
    }

    @Override
    public void write(int b) throws IOException {

        super.write(Character.toUpperCase((char) b));
    }

    @Override
    public void write(byte[] b,int off,int len) throws IOException {

        for (int i = off; i < off + len; i++) {
            b[i] = (byte) Character.toUpperCase((char) b[i]);
        }
        super.write(b,off,len);
    }

    @Override
    public void write(byte[] b) throws IOException {
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) Character.toUpperCase((char) b[i]);
        }
        super.write(b);
    }
}
