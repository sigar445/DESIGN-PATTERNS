package org.sigar.EffectiveJava.FunctionalInterfaces;

import java.util.function.UnaryOperator;
@FunctionalInterface
public interface UnaryOp<T extends Number> extends UnaryOperator<T> {

    public static void main(String[] args) {
        UnaryOp<Integer> op = x->x;
        System.out.println(op.apply(34)); // Output: 34
    }

}
