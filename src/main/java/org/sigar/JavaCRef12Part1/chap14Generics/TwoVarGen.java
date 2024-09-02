package org.sigar.JavaCRef12Part1.chap14Generics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TwoVarGen<T,V>{

    private T  ob1;
    private V  ob2;

    public static void main(String[] args) {
        TwoVarGen<Float,String> twoVarGen = new TwoVarGen<>(34.4545f,"sfsdfsd");
        System.out.println(twoVarGen.getOb1() + " " + twoVarGen.getOb2());
    }
}
