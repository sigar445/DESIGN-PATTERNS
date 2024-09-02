package org.sigar.examples.functionalInterface;

public class PrintMain {

    public static void main(String[] args){

       // Printable printable = (s) -> System.out.println("Printing ..." + s);

        Printable printable = (s) -> "Printing ..." + s;

        printThing(new Dog("buffy"));
        printThing(printable);

    }

    static void printThing(Printable thing){
        thing.print("!");
    }
}
