package org.sigar.JavaCRef12Part1.chap6Classes;

public final class _Final {

    public int getSum(int first, int second){
        return first+second;
    }

    public float getSum(float first,float second){
        System.out.println("getSum(double, double) called");
        return first + second;
    }

    public static void main(String[] args) {
        _Final finalClass = new _Final();
        float first = 2.4f,second =34.4f;
        float floatNumber = 3.14f; // 'f' indicates a float literal
        double doubleNumber = 3.14; // defaults to double
        System.out.println(
                finalClass.getSum(3.3f,34.3f));
    }
}
