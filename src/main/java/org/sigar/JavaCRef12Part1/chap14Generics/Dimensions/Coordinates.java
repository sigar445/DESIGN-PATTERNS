package org.sigar.JavaCRef12Part1.chap14Generics.Dimensions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Coordinates<T extends TwoD> {
    T[] coordinates;
//    Coordinates(T[] coordinates){
//        this.coordinates = coordinates;
//    }
    public void showXYZ(){
        for(T t : coordinates){
            System.out.println(t.x + " " + t.y);
        }
    }
}
