package org.sigar.Concurrency.Locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    private final StampedLock stampedLock= new StampedLock();
    private int data = 0;
    public void write(int value){
        long stamp = stampedLock.writeLock();
        try {
            System.out.println(Thread.currentThread().getName() + " writing " +
             value);
            data = value;
        }finally {
            stampedLock.unlock(stamp);
        }
    }
    public void optimisticRead(){

        long stamp = stampedLock.tryOptimisticRead();
        int readData = data;
        if(!stampedLock.validate(stamp)){
            stamp = stampedLock.readLock();
            try {
                readData = data;
            }finally {
                stampedLock.unlock(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName() + " read " +
                readData);
    }

    public static void main(String[] args) {
        StampedLockDemo demo = new StampedLockDemo();
        Runnable reader = () -> demo.optimisticRead();
        Runnable writer = () ->demo.write((int)(Math.random()*100));

        new Thread(reader,"readTask1").start();
        new Thread(writer,"writeTask1").start();
        new Thread(reader,"readTask2").start();
        new Thread(writer,"writeTask2").start();
        new Thread(reader,"readTask3").start();
        new Thread(writer,"writeTask3").start();
        new Thread(reader,"readTask4").start();
        new Thread(writer,"writeTask4").start();
        new Thread(reader,"readTask5").start();
        new Thread(reader,"readTask6").start();
        new Thread(reader,"readTask7").start();

    }

}
