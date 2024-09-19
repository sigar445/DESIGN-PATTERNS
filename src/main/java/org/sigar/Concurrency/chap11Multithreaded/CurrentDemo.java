package org.sigar.Concurrency.chap11Multithreaded;

public class CurrentDemo {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("Thread Running " + thread);
       // thread.getPriority();
        System.out.println("Priority "+ thread.getPriority());
        thread.setName("My thread");
        System.out.println("Thread Running " + thread);
        try {
            Thread.sleep(20000);

        }catch (InterruptedException e){
            System.out.println("Thread interruted " + e);
        }
    }
}
