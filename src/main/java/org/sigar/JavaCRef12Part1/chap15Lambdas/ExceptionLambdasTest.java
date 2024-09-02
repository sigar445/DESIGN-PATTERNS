package org.sigar.JavaCRef12Part1.chap15Lambdas;

public class ExceptionLambdasTest {
    public static void main(String[] args) throws EmptyArrayException {

        Double[] values = {3d,4d,34d};
        ExceptionInterface<Double> average = (t) ->{
            double sum = 0 ;
            if(t.length == 0) throw new EmptyArrayException();
            for(double d:t){
                sum+=d;
            }
            System.out.println(sum/t.length);
        };
        average.func(values);
        average.func(new Double[0]);
    }
}
