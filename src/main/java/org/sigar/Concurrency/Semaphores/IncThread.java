package org.sigar.Concurrency.Semaphores;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

// A thread of execution that increments count.
class IncThread implements Runnable {
    String name;
    Semaphore sem;
    CountDownLatch latch;
    IncThread(Semaphore s, String n,CountDownLatch countDownLatch) {
        sem = s;
        name = n;
        latch = countDownLatch;
    }

    public void run() {
        System.out.println("Starting " + name);
        try {
            // First, get a permit.
            System.out.println(name + " is waiting for a permit.");
            sem.acquire();
            System.out.println(name + " gets a permit.");
            // Now, access shared resource.
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
                // Now, allow a context switch -- if possible.
                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }finally {


            // Release the permit.
            System.out.println(name + " releases the permit.");
            sem.release();
            latch.countDown();
        }
    }
}
