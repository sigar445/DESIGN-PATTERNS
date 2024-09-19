package org.sigar.Concurrency.chap11Multithreaded;

import java.util.concurrent.*;

public class SumTask<T extends Number> implements Callable<Double> {
    private final T[] numbers;

    public SumTask(T[] nums){
        numbers = nums;
    }
    @Override
    public Double call() throws Exception {
        double sum=0;
        for(T num:numbers){
            sum+=num.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        ExecutorService executer = Executors.newFixedThreadPool(2);

        Integer[] numbers1 = {1, 2, 3, 4, 5};
        Integer[] numbers2 = {6, 7, 8, 9, 10};

        Future<Double> future1 = executer.submit(new SumTask<>(numbers1));
        Future<Double> future2  = executer.submit(new SumTask<>(numbers2));
        try {
            double result1 = future1.get();
            double result2 = future2.get();
            System.out.println("Sum of numbers1: " + result1);
            System.out.println("Sum of numbers2: " + result2);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executer.shutdown();
        }

    }
}
