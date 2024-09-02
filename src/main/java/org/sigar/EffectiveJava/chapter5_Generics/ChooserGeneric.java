package org.sigar.EffectiveJava.chapter5_Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserGeneric<T> {

    private final List<T> choiceList;
    //T[] choices;
    public ChooserGeneric(List<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose(){
        Random random = ThreadLocalRandom.current();
        int randVal = random.nextInt(choiceList.size());
        return choiceList.get(randVal);
    }

    public static void main(String[] args) {
        List<Integer> integerList  = List.of(4,2,5,6);
        ChooserGeneric<Integer> choices = new ChooserGeneric<>(integerList);
        System.out.println(choices.choose());
    }
}
