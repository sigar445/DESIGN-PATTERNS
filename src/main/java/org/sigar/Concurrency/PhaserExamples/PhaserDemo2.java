package org.sigar.Concurrency.PhaserExamples;

public class PhaserDemo2 {
    public static void main(String[] args) {
//        works
//        MyPhaser phsr = new MyPhaser(4, 10);
//        MyPhaser phsr = new MyPhaser(0, 10);
//        phsr.bulkRegister(4);

        MyPhaser phsr = new MyPhaser(1, 10);
        phsr.bulkRegister(3);

        System.out.println("Starting\n");
        new Thread(new MyThread(phsr, "A")).start();
        new Thread(new MyThread(phsr, "B")).start();
        new Thread(new MyThread(phsr, "C")).start();
        while(!phsr.isTerminated()) {
            phsr.arriveAndAwaitAdvance();
        }
        System.out.println("The Phaser is terminated");
    }
}
