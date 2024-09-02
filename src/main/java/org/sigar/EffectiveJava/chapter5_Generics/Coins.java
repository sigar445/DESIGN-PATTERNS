package org.sigar.EffectiveJava.chapter5_Generics;

public class Coins {
    enum TYPE {ONE,TWO,FIVE};
    private TYPE type;
    public Coins(TYPE type) {
        this.type = type;
    }
}
