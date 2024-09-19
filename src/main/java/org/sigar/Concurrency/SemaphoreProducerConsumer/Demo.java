package org.sigar.Concurrency.SemaphoreProducerConsumer;

public class Demo {

    public static void main(String[] args) {
        Q q = new Q();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);

        new Thread(producer,"PRODUCER").start();
        new Thread(consumer,"CONSUMER").start();


    }
}
