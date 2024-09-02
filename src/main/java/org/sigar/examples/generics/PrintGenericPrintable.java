package org.sigar.examples.generics;

import lombok.AllArgsConstructor;
import org.sigar.examples.functionalInterface.Printable;

@AllArgsConstructor
public class PrintGenericPrintable<T extends Printable> {

    T printable;


    public void printGenericPrintable() {
        printable.print("Hello from printable  ");
    }
}
