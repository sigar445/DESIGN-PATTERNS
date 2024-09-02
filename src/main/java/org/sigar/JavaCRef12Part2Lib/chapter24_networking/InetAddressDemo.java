package org.sigar.JavaCRef12Part2Lib.chapter24_networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        inetAddressUse();
    }
    public static void inetAddressUse() throws UnknownHostException {

        InetAddress address =  InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
    }
}
