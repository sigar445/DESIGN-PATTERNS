package org.sigar.Generics;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public class TwoVarGenerics<T,K>{

    T[] firstArr;
    K[] secondArr;

    public void printTwoVarGenerics() {
        Arrays.stream(firstArr).forEach(System.out::println);
        Arrays.stream(secondArr).forEach(System.out::println);
    }
    public <T,K> int combineArrSize(T[] first,K[] second){

        int min = Math.min(first.length, second.length);
        for(int ind = 0; ind < min; ind++){
            System.out.println(first[ind] + " " + second[ind]);
        }
        return first.length + second.length;
    }

    public static void main(String[] args){
        TwoVarGenerics<Integer,Character> twoVarGenerics =
                new TwoVarGenerics<>(new Integer[]{32,324,234,45}
                        ,new Character[]{'a','b','c'});
        twoVarGenerics.printTwoVarGenerics();
        twoVarGenerics.combineArrSize(twoVarGenerics.getFirstArr(),twoVarGenerics.getSecondArr());
    }

}
