package org.sigar.EffectiveJava.chapter6_ENUM;

import java.awt.image.BufferedImageFilter;
import java.util.function.BiFunction;

public enum OperationLambda{

    PLUS("+", Double::sum);

    String op;
    //public abstract double apply(double x, double y);
    public final BiFunction<Double, Double, Double>  operation;
    OperationLambda(String op, BiFunction<Double, Double, Double> operation) {
        this.op = op;
        this.operation = operation;
    }

    public double apply(double a, double b){
        return operation.apply(a, b);
    }
}
