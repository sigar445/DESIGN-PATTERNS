package org.sigar.JavaCRef12Part1.chap10ExceptionHandling;

public class ExceptionDemo {
    public static void main(String[] args) {

        try{
            compute(2);
            compute(334);
        }catch (CustomException e){
            System.out.println("Caught exception " + e );
        }


    }

    static void compute (int val) throws CustomException {
        System.out.println("Inside compute with " + val);
        if(val>10)
            throw new CustomException(val);
        System.out.println("Normal Exit with compute method");
    }

}
