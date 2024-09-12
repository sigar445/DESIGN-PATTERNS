package org.sigar.JavaCRef12Part2Lib.chap20_collection.MyDeque;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Person {
    private String name;
    private int age;
    public Person(int age){
        this.age = age;
        name = "";
    }
    public Person(String name){
        age = 10;
        this.name = name;
    }
    @Override
    public String toString() {
        return name + " " + age;
    }
}
