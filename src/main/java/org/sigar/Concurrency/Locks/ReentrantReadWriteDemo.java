package org.sigar.Concurrency.Locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteDemo {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int data = 0;

    public void read() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reading " +
                    data);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write(int value) {
        lock.writeLock().lock();
        try {
            data = value;
            System.out.println(Thread.currentThread().getName() + " writing " +
                    data);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteDemo demo = new ReentrantReadWriteDemo();
        Runnable readTask = demo::read;
        Runnable writeTask = () -> demo.write(23);
        new Thread(readTask,"Reading").start();
        new Thread(writeTask,"Writing").start();
        new Thread(readTask,"Reading2").start();
        new Thread(readTask,"Reading3").start();
        new Thread(readTask,"Reading4").start();
    }
}
