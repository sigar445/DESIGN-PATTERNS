package org.sigar.JavaCRef12Part1.chap5Loops;

public class _Break {
    public static void main(String[] args) {
        boolean t = true;
        first: {
            second: {
                third: {
                    System.out.println("Before the break.");
                    if(t) break first; // break out of second block
                    System.out.println("This won't execute");
                }
                System.out.println("This won't execute");
            }
            System.out.println("This is after second block.");
        }
        System.out.println("This is after first block.");

    }
}

