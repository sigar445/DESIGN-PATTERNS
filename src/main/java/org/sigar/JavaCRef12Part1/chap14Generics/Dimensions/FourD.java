package org.sigar.JavaCRef12Part1.chap14Generics.Dimensions;

import lombok.Getter;

@Getter
public class FourD extends ThreeD{
    private int t;
    public FourD(int a,int b,int c,int d){
        super(a,b,c);
        t = d;
    }
}
