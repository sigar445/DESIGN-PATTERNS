package org.sigar.Networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

    public static void inetAddressUse() throws UnknownHostException {

//        InetAddress address =  InetAddress.getLocalHost();
//        System.out.println(address.getHostAddress());
        try {
            // Get InetAddress object for a hostname (e.g., google.com)
            InetAddress address = InetAddress.getByName("google.com");

            // Display the IP address and hostname
            System.out.println("Host Name: " + address.getHostName());
            System.out.println("IP Address: " + address.getHostAddress());

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Get all IP addresses for a hostname
            InetAddress[] addresses = InetAddress.getAllByName("google.com");

            // Display all IP addresses
            for (InetAddress address : addresses) {
                System.out.println("IP Address: " + address.getHostAddress());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addressNaming() throws UnknownHostException {
        InetAddress Address = InetAddress.getLocalHost();
        System.out.println(Address);
        Address = InetAddress.getByName("www.HerbSchildt.com");
        System.out.println(Address);
        InetAddress[] SW = InetAddress.getAllByName("www.nba.com");
        for (int i=0; i<SW.length; i++)
            System.out.println(SW[i]);
    }

    public static void main(String[] args) throws UnknownHostException {
        inetAddressUse();
       // addressNaming();
    }

}
