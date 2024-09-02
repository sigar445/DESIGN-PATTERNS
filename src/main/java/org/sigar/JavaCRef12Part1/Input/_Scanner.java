package org.sigar.JavaCRef12Part1.Input;

import java.util.Scanner;

public class _Scanner {
    public static void main(String[] args) {

        Scanner  sc = new Scanner(System.in);
        int first  = sc.nextInt();
        System.out.println(first);
        sc.close();
    }
}
