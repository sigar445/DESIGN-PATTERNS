package org.sigar.EffectiveJava.chapter5_Generics;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser {
    private final Object[] choiceArray;

    public Chooser(Collection choices) {
        this.choiceArray = choices.toArray();
    }

    public Object[] choose(){
        Random rnd = ThreadLocalRandom.current();
        return (Object[]) choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
