package org.sigar.Networking.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ClientUDP {
    public static int serverPort = 998;
    public static int clientPort = 999;
    public static int buffer_size = 1024;
    public static DatagramSocket ds;
    public static byte[] buffer = new byte[buffer_size];
    public static void TheClient() throws Exception {
        int count = 0;
        while(true) {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            ds.receive(p);
            System.out.println(new String(p.getData(), 0, p.getLength()));
            p.setData(("Hello from the client Message: " + count++).getBytes());
            ds.send(p);
        }
    }

    public static void main(String[] args) throws Exception {
        ds = new DatagramSocket(clientPort);
        TheClient();
    }
}
