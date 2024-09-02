package org.sigar.EffectiveJava.chapter2.item4_SIngleton;

public class SIngletonTest {
    public static void main(String[] args) {


        SingletonIMP imp = SingletonIMP.INSTANCE;
        imp.doSomething();
    }
}
