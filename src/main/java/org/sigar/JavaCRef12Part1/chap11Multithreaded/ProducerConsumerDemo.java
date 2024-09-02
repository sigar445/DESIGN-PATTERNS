package org.sigar.JavaCRef12Part1.chap11Multithreaded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerDemo {

    public static void main(String[] args) {


        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        String[] values = {
                "fsfdfsd1",
                "sfsdfsdf2",
                "fsfdfsd3",
                "sfsdfsdf4",
                "fsfdfsd5",
                "sfsdfsdf6",
                "fsfdfsd7",
                "sfsdfsdf8",
                "fsfdfsd9",
                "sfsdfsdf10",
                "fsfdfsd11",
                "sfsdfsdf12",
        };
        Producer<String> producer = new Producer<>(queue,values);
        Consumer<String> consumer = new Consumer<>(queue);
        Thread prodThread = new Thread(producer);
        Thread consThread = new Thread(consumer);
        prodThread.start();
        consThread.start();

    }
}
