package org.sigar.Concurrency.CountDownLatch;

import lombok.AllArgsConstructor;

import java.util.concurrent.CountDownLatch;


@AllArgsConstructor
public class Worker implements Runnable{
    CountDownLatch countDownLatch;
    public void run() {

        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " working on the task ");
            Thread.sleep(1000);
          //  System.out.println(threadName + " waiting at the barrier");
          //  System.out.println(threadName + " proceeding from the barrier");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            countDownLatch.countDown();
        }
    }
}
