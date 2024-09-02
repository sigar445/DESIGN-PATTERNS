package org.sigar.examples.generics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IntegerPrinter {

    Integer integerToPrint;

    public void print(){
        System.out.println(integerToPrint);
    }
}
