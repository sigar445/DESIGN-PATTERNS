package org.sigar.JavaCRef12Part1.chap14Generics;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Average <T extends Number>{
    T[] nums;

    public double average(){
        double sum=0;
        for(T num : nums) {
            sum = sum + num.doubleValue();
        }
        return sum/ nums.length;
    }

    boolean isSameAvg(Average<?> ob) {
        if(average() == ob.average())
            return true;
        return false;
    }
    public static void main(String[] args) {
        Double[] nums = {34d,3453d,34543d,34535d};
        Average<Double> average = new Average<>(nums);
        System.out.println(average.average());
    }

}
