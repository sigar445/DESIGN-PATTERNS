package org.sigar.Concurrency.chap11Multithreaded;

public class NewThread extends Thread {

    @Override
    public void run() {
        try {
            for(int ind =0;ind < 5;ind++){
                System.out.println("Inside " + Thread.currentThread());
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            System.out.println("Child interrupted");
        }
        System.out.println("Exiting child Thread");
    }
}
