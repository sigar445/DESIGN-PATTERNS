package org.sigar.EffectiveJava.chapter6_ENUM.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

public class AvoidAnonymous {


    public enum Operation{
        PLUS("+",(x, y) -> x+y);

        private final String symbol;
        private final DoubleBinaryOperator operation;

        Operation(String symbol, DoubleBinaryOperator op){
            this.symbol = symbol;
            this.operation = op;
        }
        @Override public String toString() { return symbol; }

        public double apply(double first, double second){
            return operation.applyAsDouble(first,second);
        }
    }

    public static void main(String[] args) {

        List<Integer> arraylist  = Arrays.asList(45,234234,57755,33,343,4545);

        arraylist.sort((x, y) -> y.compareTo(x));
        arraylist.forEach(System.out::println);

        List<String> stringLIst = Arrays.asList("sfsd","sfsfsfsd","sd","ewrweew","ce");
        stringLIst.sort((x,y)->Integer.compare(y.length(),x.length()));
        stringLIst.forEach(System.out::println);
        Operation op = Operation.PLUS;
        System.out.println(op.apply(34,343));


    }
}
