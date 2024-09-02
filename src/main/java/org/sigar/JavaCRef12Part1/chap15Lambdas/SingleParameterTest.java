package org.sigar.JavaCRef12Part1.chap15Lambdas;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SingleParameterTest {
    public static void main(String[] args) {
        reverseString();
    }

    static void reverseString(){
        try(Scanner sc = new Scanner(System.in)) {
            String input = sc.next();
            Function<String,String> f;
            f = (val)-> new StringBuilder(val).reverse().toString();
            System.out.println(f.apply(input));
        }
    }
}
