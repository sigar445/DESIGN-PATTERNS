package org.sigar.Generics;

public class GenericsVariableTest {

    public static void main(String[] args) {


        GenericsVariable<Integer> intVal = new GenericsVariable<>(34);
        GenericsVariable<Double> doubleGenericsVariable = new GenericsVariable<>(34.5);
        System.out.println(intVal.getValue());
        System.out.println(doubleGenericsVariable.getValue());


    }
}
