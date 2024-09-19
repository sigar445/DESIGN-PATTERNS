package org.sigar.Concurrency.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class ReentrantLockDemo {
    private final Lock lock = new ReentrantLock();
    public  void accessResource() throws InterruptedException {

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            sleep(1000);
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        Runnable task = () -> {
            try {
                demo.accessResource();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        new Thread(task,"task1").start();
        new Thread(task,"task2").start();

    }
}
