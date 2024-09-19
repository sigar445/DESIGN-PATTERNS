package org.sigar.Concurrency;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class SumTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 20; // Threshold to divide the task
    private int[] numbers;
    private int start;
    private int end;

    // Constructor
    public SumTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    // The compute method where the task will be divided and executed
    @Override
    protected Integer compute() {
        int length = end - start;

        // If the task is small enough, compute the sum directly
        if (length <= THRESHOLD) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        } else {
            // Split the task into two subtasks
            int mid = start + length / 2;
            SumTask leftTask = new SumTask(numbers, start, mid);
            SumTask rightTask = new SumTask(numbers, mid, end);

            // Fork the subtasks (run them in parallel)
            leftTask.fork(); // asynchronously execute the left task
            rightTask.fork(); // asynchronously execute the right task

            // Wait for the subtasks to finish and combine their results
            int leftResult = leftTask.join(); // waits for the result from the left task
            int rightResult = rightTask.join(); // waits for the result from the right task

            // Combine results from both subtasks
            return leftResult + rightResult;
        }
    }
}
