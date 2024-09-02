package org.sigar.EffectiveJava.chapter2.item4_SIngleton;

public enum SingletonIMP {
    INSTANCE;


    public void doSomething() {
        System.out.println("I am a Singleton");
    }
}
