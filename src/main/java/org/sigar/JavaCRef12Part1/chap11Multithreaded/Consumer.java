package org.sigar.JavaCRef12Part1.chap11Multithreaded;

import java.util.concurrent.BlockingQueue;

public class Consumer<T> implements Runnable{

    private final BlockingQueue<T> queue;

    public Consumer(BlockingQueue<T> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while(true){
            try {
                T val = queue.take();
                System.out.println("Thread Consumed " + val);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
