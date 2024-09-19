package org.sigar.Concurrency.PhaserExamples;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {

    int numPhases;
    MyPhaser(int parties,int numPhases){
        super(parties);
        this.numPhases = numPhases-1;
    }

    @Override
    public boolean onAdvance(int phase, int registeredParties) {

        System.out.println("Phase " + phase + " Completed");
        return registeredParties == 0 || phase == numPhases;

    }
}
