package org.sigar.JavaCRef12Part1.chap11Multithreaded;

public class Caller implements Runnable{

    String msg;
    final Callme callme;
    Thread t;
    public Caller(String msg,Callme callme){
        this.msg = msg;
        this.callme = callme;
        t = new Thread(this);
    }
    @Override
    public void run() {
        synchronized (callme) {
            callme.call(msg);
        }
    }
}
