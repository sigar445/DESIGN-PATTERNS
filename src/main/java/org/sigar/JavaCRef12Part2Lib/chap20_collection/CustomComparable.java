package org.sigar.JavaCRef12Part2Lib.chap20_collection;

import lombok.Getter;

@Getter
public class CustomComparable<T> implements Comparable<CustomComparable<T>>{
    double val;
    T genericVal;
    CustomComparable(double val,T genericVal){
        this.val = val;
        this.genericVal = genericVal;
    }
    public int compareTo(CustomComparable o) {
        return Double.compare(getVal(),o.getVal());
    }
    @Override
    public String toString(){
        return "Val : genericVal == " + getVal() + " : " + genericVal;
    }
}

