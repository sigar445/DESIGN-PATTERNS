package org.sigar.Concurrency.chap11Multithreaded;

import lombok.Getter;

@Getter
public class Counter {

    private int count = 0;

    synchronized public void increment(){
        count++;
    }

    public static void main(String[] args) {

        Counter counter =  new Counter();

        Runnable task = ()->{
            for (int ind = 0; ind < 10000; ind++) {
                counter.increment();
            }
        };
        Thread thread = new Thread(task);
        Thread thread1 = new Thread(task);

        thread.start();
        thread1.start();

        try{
            thread1.join();
            thread.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("Counter val is " + counter.getCount());

    }
}
