package org.sigar.EffectiveJava.FunctionalInterfaces;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;

public class BinaryOp {


    public static void main (String[] args){


        BinaryOperator<Double>  op = Double::sum;
        double sum  = op.apply(34.0,34.34);
        DoubleBinaryOperator doubleBinaryOperator = (a,b)->Double.min(a,b);
        System.out.println(sum);
        System.out.println(doubleBinaryOperator.applyAsDouble(34.3453,66));





    }
}
