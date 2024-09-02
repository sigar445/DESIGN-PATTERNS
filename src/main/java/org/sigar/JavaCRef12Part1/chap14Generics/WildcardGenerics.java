package org.sigar.JavaCRef12Part1.chap14Generics;

public class WildcardGenerics {


    public static void main(String[] args) {
        Integer[] intVals = {100,25,35,40};
        Double[] doubleVals = {50.00,20.00,80.00};
        Average<Integer> iog = new Average<>(intVals);
        Average<Double> dob = new Average<>(doubleVals);
        if(iog.isSameAvg(dob))
            System.out.println("Same average for " + intVals + " " + doubleVals);

        if(iog.average() == dob.average()){
            System.out.println("Same average for " + intVals + " " + doubleVals);
        }
        Float[] fnums = { 1.0F, 2.0F, 3.0F, 4.0F, 5.0F };
        Average<Float> fob = new Average<>(fnums);
        double x = fob.average();
        System.out.println("fob average is " + x);

        System.out.print("Averages of iob and dob ");
        if(iog.isSameAvg(dob))
            System.out.println("are the same.");
        else
            System.out.println("differ.");
        System.out.print("Averages of iob and fob ");
        if(iog.isSameAvg(fob))
            System.out.println("are the same.");
        else
            System.out.println("differ.");

    }

}
