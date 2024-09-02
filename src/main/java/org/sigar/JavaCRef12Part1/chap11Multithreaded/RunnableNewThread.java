package org.sigar.JavaCRef12Part1.chap11Multithreaded;

public class RunnableNewThread implements Runnable{
    @Override
    public void run() {
        try{
            for (int i = 0; i < 10; i++) {
                System.out.println("Inside " + Thread.currentThread());
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            System.out.println(e.toString());
        }
    }
}
