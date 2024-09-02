package org.sigar.JavaCRef12Part1.chap14Generics;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Supplier;

@AllArgsConstructor
public class MinMax<T extends Number> implements MinMaxGenericInf<T>{
    final T [] values;


    public T max() {
        return Arrays.stream(values)
                .max(Comparator.comparingDouble(Number::doubleValue))
                .orElse(null);

     }

    public T min() {
        return Arrays.stream(values)
                .min(Comparator.comparingDouble(Number::doubleValue))
                .orElse(null);

    }

    public static void main(String[] args) {

        Double[] doubleVals = {3.4,3443.43,3454.65,-3443.43};
        MinMax<Double> doubleMinMax = new MinMax<>(doubleVals);

        System.out.println("Min and max are : " + doubleMinMax.min() + "  " + doubleMinMax.max() );
    }

}
