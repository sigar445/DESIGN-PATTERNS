package org.sigar.JavaCRef12Part2Lib.chap20_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

public class SpliteratorExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            numbers.add(i);
        }

        Spliterator<Integer> spliterator = numbers.spliterator();
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.submit(() -> processSpliterator(spliterator)).join();
        forkJoinPool.shutdown();
    }

    private static void processSpliterator(Spliterator<Integer> spliterator) {
        Spliterator<Integer> split;
        AtomicInteger count = new AtomicInteger();

        while ((split = spliterator.trySplit()) != null) {
            // Process each half concurrently
            count.getAndIncrement();
            Spliterator<Integer> finalSplit = split;
            ForkJoinPool.commonPool().submit(() -> processSpliterator(finalSplit));
        }
        // Process the remaining elements sequentially
        spliterator.forEachRemaining(element -> {
           System.out.println("Processing element: " + element);
        });
        System.out.println(count.get());
    }

}
