package org.sigar.JavaCRef12Part1.chap14Generics;

import lombok.Getter;

@Getter
public class GenConstructor {

    double val;

   public <T extends Number> GenConstructor(T val){
        this.val = val.doubleValue();
    }

    public static void main(String[] args) {

        GenConstructor intCons= new GenConstructor(34);
        GenConstructor floatCons= new GenConstructor(34f);
        System.out.println(intCons.getVal() + "  " + floatCons.getVal());

    }
}
