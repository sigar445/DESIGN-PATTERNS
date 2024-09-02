package org.sigar.EffectiveJava.FunctionalInterfaces;

import java.util.function.Function;

public class FunctionInfer {


    static Function<Integer,Integer> incrementByOne  = x->x+1;

    public static void main(String[] args) {

        System.out.print(incrementByOne.apply(34));



    }
}
