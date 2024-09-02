package org.sigar.JavaCRef12Part2Lib.chap21_java_util;

import java.util.BitSet;

public class BitSetDemo {

    public static void main(String[] args) {

        BitSet bitSet =  new BitSet(32);
        BitSet bitSet2 = new BitSet(32);


        for(int ind = 1;ind < 32   ; ind++){
            if(ind%2 == 0){
                bitSet.set(ind);
            }
            if(ind%3 == 0 ){
                bitSet2.set(ind);
            }
        }
        BitSet bitSet3 = (BitSet) bitSet2.clone();
        System.out.println("Initial pattern in bits1: ");
        System.out.println(bitSet);
        System.out.println("\nInitial pattern in bits2: ");
        System.out.println(bitSet2);

        // AND bits
//        bitSet2.and(bitSet);
//        System.out.println("\nbits2 AND bits1: ");
//        System.out.println(bitSet2);
//        // OR bits
//        bitSet2.or(bitSet);
//        System.out.println("\nbits2 OR bits1: ");
//        System.out.println(bitSet2);
        // XOR bits
        bitSet2.xor(bitSet);
        System.out.println("\nbits2 XOR bits2: ");
        System.out.println(bitSet2);


        System.out.println("Initial pattern in bits2: ");
        System.out.println(bitSet2);
        System.out.println("\nInitial pattern in bits3: ");
        System.out.println(bitSet3);


        bitSet2.stream().forEach(System.out::println);


    }
}
