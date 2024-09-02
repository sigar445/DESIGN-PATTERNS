package org.sigar.EffectiveJava.chapter5_Generics.Union;

import java.util.function.UnaryOperator;

public class IdentityFunction {


    private static final UnaryOperator<Object> operator = (t) -> t;
    private static final MyOperator<Object> secondOperator = new MyOperator<>();
    public static void main(String[] args) {
        String input = "World";
        String[] strings = {"sdfs","erses","werwr"};
        String output = (String) secondOperator.apply(input);


        for(String string : strings)
            secondOperator.apply(string);
        System.out.println(output);
    }
}
