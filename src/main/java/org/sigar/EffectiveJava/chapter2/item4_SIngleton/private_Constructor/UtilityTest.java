package org.sigar.EffectiveJava.chapter2.item4_SIngleton.private_Constructor;

import java.util.Collections;

public class UtilityTest {
    public static void main(String[] args) {


        Utility utility = Utility.getInstance();
        utility.doSomething();

    }
}
