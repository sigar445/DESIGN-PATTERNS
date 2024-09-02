package org.sigar.JavaCRef12Part1.chap14Generics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GenericsDemo<T>{
    T demo;
    void showType() {
        System.out.println("Type of T is " +
                demo.getClass().getName());
    }



    public static void main(String[] args) {
        GenericsDemo<Integer> demo = new GenericsDemo<>(34);
        System.out.println(demo.getDemo());

        GenericsDemo<String> stringDemo = new GenericsDemo<>("sfds");
        System.out.println(stringDemo.getDemo());
        stringDemo.showType();

    }

}
