package org.sigar.Concurrency;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ForkJoinExample {
    public static void main(String[] args) {
        // Create an array of numbers
        int[] numbers = new int[100];
        IntStream.range(0,100).parallel().forEach(ind -> numbers[ind] = ind*256);

        // Create a ForkJoinPool to execute tasks
        ForkJoinPool pool = new ForkJoinPool();

        // Create the main task to sum the entire array
        SumTask mainTask = new SumTask(numbers, 0, numbers.length);

        // Execute the main task in the ForkJoinPool
        int result = pool.invoke(mainTask); // This method blocks until the result is ready

        // Output the result
        System.out.println("Sum: " + result);
    }
}
