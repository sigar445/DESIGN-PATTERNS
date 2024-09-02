package org.sigar.JavaCRef12Part1.chap10ExceptionHandling;

public class MultiCatch {
    public static void main(String[] args) {

        int a = 10,b = 0;
        int [] vals = {1, 2, 3};
        try {
            a = a/b;
            a = vals[45];
        }catch (ArithmeticException | IndexOutOfBoundsException e){
            System.out.println("Caught Exception " + e);
        }
        System.out.println("After multi catch");
    }
}
