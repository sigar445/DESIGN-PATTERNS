package org.sigar.EffectiveJava.chapter2.item4_SIngleton.private_Constructor;

import lombok.Getter;

public class Utility {
    // Suppress default constructor for noninstantiability
    private Utility(){
       // throw new AssertionError();
    }
    @Getter
    private static final Utility instance = new Utility();



    public void doSomething(){
        System.out.println("Utility private constructor");
    }
}
