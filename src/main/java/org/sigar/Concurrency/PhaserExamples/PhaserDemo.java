package org.sigar.Concurrency.PhaserExamples;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void phaser0() {

        // won't work has to be 0
        Phaser phaser = new Phaser(0);

        new Thread(new Worker(phaser,"Thread1")).start();

        new Thread(new Worker(phaser,"Thread2")).start();
        new Thread(new Worker(phaser,"Thread3")).start();
        new Thread(new Worker(phaser,"Thread4")).start();
        new Thread(new Worker(phaser,"Thread5")).start();
        new Thread(new Worker(phaser,"Thread6")).start();
    }
    public static void phaserWithNumbers() {
        Phaser phsr = new Phaser(1);
        int curPhase;
        System.out.println("Starting");
        new Thread(new Worker(phsr, "A")).start();
        new Thread(new Worker(phsr, "B")).start();
        new Thread(new Worker(phsr, "C")).start();
        // Wait for all threads to complete phase one.
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " Complete");
        // Wait for all threads to complete phase two.
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " Complete");
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " Complete");
        // Deregister the main thread.
        phsr.arriveAndDeregister();
        if(phsr.isTerminated())
            System.out.println("The Phaser is terminated");
    }

    public static void main(String[] args) {
        phaserWithNumbers();
    }
}



