package org.sigar.JavaCRef12Part1.chap14Generics.Dimensions;

import lombok.Getter;

@Getter
public class ThreeD extends TwoD{

    private int z;
    public ThreeD(int x,int y,int z){
        super(x,y);
        this.z = z;
    }
}
