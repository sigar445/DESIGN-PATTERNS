package org.sigar.Concurrency.CyclicBarrier;

import lombok.AllArgsConstructor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
@AllArgsConstructor
public class Worker implements Runnable{

    private CyclicBarrier barrier;
    @Override
    public void run() {


        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " working on the task " );
            Thread.sleep(1000);
            System.out.println(threadName + " waiting at the barrier");
            barrier.await();
            System.out.println(threadName + " proceeding from the barrier");
        } catch (InterruptedException  | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
