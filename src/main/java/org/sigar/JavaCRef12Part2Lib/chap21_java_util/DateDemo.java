package org.sigar.JavaCRef12Part2Lib.chap21_java_util;

import java.time.Instant;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        DateDemo demo = new DateDemo();
        Date  date = new Date();
        System.out.println(date.toInstant());

        System.out.println(date);
        long mSec = date.getTime();
        System.out.println(mSec);
        demo.call("Waiting");
        Instant ins = Instant.now();
        System.out.println(ins);
    }
    void call(String msg){
        System.out.print("[ " + msg);
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(" ]");
    }
}
