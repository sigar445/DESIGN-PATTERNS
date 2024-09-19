package org.sigar.Concurrency.PhaserExamples;

import lombok.Getter;

import java.util.concurrent.Phaser;

@Getter
public class Worker implements Runnable{
    Phaser phaser;
    String name;
    Worker(Phaser phaser,String name){
        this.phaser = phaser;
        this.name = name;
        this.phaser.register();
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " Beginning Phase One");
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread " + name + " Beginning Phase Two");
        phaser.arriveAndAwaitAdvance();

        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " Beginning Phase Three");
        phaser.arriveAndAwaitAdvance();

        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " Beginning Phase Four");
        phaser.arriveAndDeregister();

    }
}
