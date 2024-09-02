package org.sigar.JavaCRef12Part1.chap11Multithreaded;

import java.util.concurrent.BlockingQueue;

public class Producer<T> implements Runnable{
    private final BlockingQueue<T> queue;
    private final T[] values;
    Producer(BlockingQueue<T> queue,T[] vals){
        this.queue = queue;
        this.values = vals;
    }

    @Override
    public void run() {
        try{
            for (T val: values) {
                System.out.println("Producer adding " + val);
                queue.put(val);
                Thread.sleep(3000);
            }
        }catch (InterruptedException e){
            System.out.println("Caught exception " + e);
        }
    }
}
