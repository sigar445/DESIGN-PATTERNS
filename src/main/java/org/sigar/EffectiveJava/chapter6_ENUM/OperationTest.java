package org.sigar.EffectiveJava.chapter6_ENUM;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperationTest {


    public static void main(String[] args) {
        Operation addition = Operation.PLUS;
        System.out.println(addition.apply(3,6));

        OperationLambda plusLambda = OperationLambda.PLUS;
        double sum = plusLambda.apply(3,6);
        System.out.println(sum);

        double val = Operation.fromString("+").get().apply(334,43);
        System.out.println(val);

        List<String> elements = Arrays.asList("apple", "banana", "orange");

        Map<String,String> identityMap= elements.stream().
                collect(Collectors.toMap(e->e,e->e));
        System.out.println(identityMap);

    }


}


