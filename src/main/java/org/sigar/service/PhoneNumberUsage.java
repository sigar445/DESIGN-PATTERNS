package org.sigar.service;

import org.sigar.model.PhoneNumber;

public class PhoneNumberUsage {

    public static void main(String[] args) {

        PhoneNumber p1 = new PhoneNumber(23,54,213);

        PhoneNumber p2 = new PhoneNumber(213,54,213);

        PhoneNumber p3 = new PhoneNumber(23,54,213);
        System.out.println(p1.equals(p1));
    }
}
