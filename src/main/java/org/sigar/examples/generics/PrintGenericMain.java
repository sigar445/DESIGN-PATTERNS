package org.sigar.examples.generics;

import org.sigar.examples.functionalInterface.Dog;

public class PrintGenericMain {

    public static void main(String[] args) {
//        PrintGeneric<Integer> integerPrintGeneric= new PrintGeneric<>(34);
//
//        integerPrintGeneric.printThing();
//
//        PrintGeneric<String> stringPrintGeneric= new PrintGeneric<>("Hello");
//        stringPrintGeneric.printThing();
        PrintGenericPrintable <Dog> dogPrintable = new
                PrintGenericPrintable<>(new Dog("Timmy"));
        dogPrintable.printGenericPrintable();
    }
}
