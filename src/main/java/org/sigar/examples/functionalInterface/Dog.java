package org.sigar.examples.functionalInterface;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Dog implements Printable{
    private String name;

    @Override
    public String print(String val ) {
        System.out.println(name + "  " + val);
        return name + " " + val;
    }
}
