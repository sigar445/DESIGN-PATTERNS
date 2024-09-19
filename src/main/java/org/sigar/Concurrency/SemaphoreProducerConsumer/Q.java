package org.sigar.Concurrency.SemaphoreProducerConsumer;

import java.util.concurrent.Semaphore;

public class Q {
    private int n;
    static Semaphore semProducer = new Semaphore(1);
    static Semaphore semConsumer = new Semaphore(0);
    void get(){
        try {
            semConsumer.acquire();
        }catch (InterruptedException e){
            System.out.println("Caught Interrupted Exception");
        }finally {
            System.out.println("Got " + n);
            semProducer.release();
        }

    }
    void put(int val){
        try {
            semProducer.acquire();
        }catch (InterruptedException e){
            System.out.println("Caught Interrupted Exception");
        }
        n = val;
        System.out.println("Setting n: " + val );
        semConsumer.release();
    }
}
