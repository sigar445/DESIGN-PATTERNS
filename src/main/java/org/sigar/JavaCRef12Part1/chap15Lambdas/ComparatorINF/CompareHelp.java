package org.sigar.JavaCRef12Part1.chap15Lambdas.ComparatorINF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CompareHelp {

    static public int compareMC(MyClass first,MyClass second){
        return first.getVal()- second.getVal();
    }

    public static void main(String[] args) {
        ArrayList<MyClass> al = new ArrayList<MyClass>();
        al.add(new MyClass(1));
        al.add(new MyClass(4));
        al.add(new MyClass(2));
        al.add(new MyClass(9));
        al.add(new MyClass(3));
        al.add(new MyClass(7));

        MyClass maxClass = Collections.max(al,CompareHelp::compareMC);
        System.out.println(maxClass.getVal());
    }
}
