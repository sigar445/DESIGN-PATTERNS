package org.sigar.JavaCRef12Part1.chap6Classes;

public class _MethodOverloading {

    //Method overloading will have methods with same firstName but with different
    // parameters

    public int getSum(int first,int second){
        return first+second;
    }

    public float getSum(float first,float second){
        return first + second;
    }

}
