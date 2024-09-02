package org.sigar.examples.generics;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PrintGeneric <T>{
    T thingToPrint;

    public void printThing(){
        System.out.println(thingToPrint);
    }

}
