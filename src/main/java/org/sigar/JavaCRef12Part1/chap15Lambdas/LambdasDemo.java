package org.sigar.JavaCRef12Part1.chap15Lambdas;

import java.util.Scanner;
import java.util.function.Function;

public class LambdasDemo {

    public static void main(String[] args) {
        FunctionalInterface<Double> f = () -> 34d;
        System.out.println(f.result());

        f = ()-> (Math.random()*100);
        System.out.println(f.result());
    }

    void lambdaArgumentTest(){
        try(Scanner sc = new Scanner(System.in)) {
            String input = sc.next();
            LambdasArgument<String,String> f = new LambdasArgument<>();
            String output = f.run((s)->new StringBuilder(String.valueOf(s)).reverse().toString(),input);

            System.out.println(output);

        }

    }
}
