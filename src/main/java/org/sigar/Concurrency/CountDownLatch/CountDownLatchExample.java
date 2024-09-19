package org.sigar.Concurrency.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);

        new Thread(new Worker(latch),"task1").start();
        new Thread(new Worker(latch),"task4").start();
        new Thread(new Worker(latch),"task3").start();
        new Thread(new Worker(latch),"task2").start();

        System.out.println("Main thread waiting for workers to finish...");
        latch.await();  // Wait until all workers have called countDown()
        System.out.println("All workers finished. Main thread proceeding...");

        new Thread(new Worker(latch),"task5").start();
        new Thread(new Worker(latch),"task6").start();
        new Thread(new Worker(latch),"task7").start();
        new Thread(new Worker(latch),"task8").start();

        System.out.println("Main thread waiting for workers to finish...");
        latch.await();  // Wait until all workers have called countDown()
        System.out.println("All workers finished. Main thread proceeding...");
    }
}
