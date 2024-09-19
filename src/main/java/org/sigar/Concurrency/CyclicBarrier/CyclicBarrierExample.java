package org.sigar.Concurrency.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4);

        new Thread(new Worker(barrier),"task1").start();
        new Thread(new Worker(barrier),"task2").start();
        new Thread(new Worker(barrier),"task3").start();
        new Thread(new Worker(barrier),"task4").start();


        // Reusing the same barrier for another round of synchronization
        try {
            Thread.sleep(5000); // Simulate some delay between barrier cycles
            System.out.println("Reusing the same barrier for the next phase...");
            for (int i = 0; i < 4; i++) {
                new Thread(new Worker(barrier),String.format("task%d",i+5)).start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
