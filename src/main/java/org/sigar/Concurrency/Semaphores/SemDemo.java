package org.sigar.Concurrency.Semaphores;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
class SemDemo {
    public static void incDecCountWithSemaphoreLatch() throws InterruptedException {
        Semaphore sem = new Semaphore(1);
        CountDownLatch latch = new CountDownLatch(12);
//        new Thread(new IncThread(sem, "A")).start();
//        new Thread(new DecThread(sem, "B")).start();

        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(new IncThread(sem, "A", latch));
        executor.submit(new IncThread(sem, "B", latch));
        executor.submit(new DecThread(sem, "C", latch));
        executor.submit(new IncThread(sem, "D", latch));
        executor.submit(new DecThread(sem, "E", latch));
        executor.submit(new DecThread(sem, "F", latch));
        executor.submit(new IncThread(sem, "G", latch));
        executor.submit(new DecThread(sem, "H", latch));
        executor.submit(new IncThread(sem, "I", latch));
        executor.submit(new IncThread(sem, "J", latch));
        executor.submit(new DecThread(sem, "K", latch));
        executor.submit(new DecThread(sem, "L", latch));
        try {
            latch.await(); // Wait for all tasks to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown(); // Shut down the executor service
        System.out.println("End of the program");
        //executor.wait();
    }
    public static void incDecCountWithRunnableList() throws InterruptedException{
        ExecutorService executor = Executors.newFixedThreadPool(6);
        Semaphore sem = new Semaphore(1);
        CountDownLatch latch = new CountDownLatch(6);
        List<Callable<Object>> tasks = new ArrayList<>();

        tasks.add(Executors.callable(new IncThread(sem, "A", latch)));
        tasks.add(Executors.callable(new IncThread(sem, "B", latch)));
        tasks.add(Executors.callable(new DecThread(sem, "C", latch)));
        tasks.add(Executors.callable(new IncThread(sem, "D", latch)));
        tasks.add(Executors.callable(new DecThread(sem, "E", latch)));
        tasks.add(Executors.callable(new DecThread(sem, "F", latch)));
        tasks.add(Executors.callable(new IncThread(sem, "G", latch)));
        tasks.add(Executors.callable(new DecThread(sem, "H", latch)));
        tasks.add(Executors.callable(new IncThread(sem, "I", latch)));
        tasks.add(Executors.callable(new IncThread(sem, "J", latch)));
        tasks.add(Executors.callable(new DecThread(sem, "K", latch)));
        tasks.add(Executors.callable(new DecThread(sem, "L", latch)));

        // Invoke all tasks at once
        List<Future<Object>> results =  executor.invokeAll(tasks);
        results.forEach(result -> {
            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        try {
            latch.await(); // Wait for all tasks to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown(); // Shut down the executor service
        System.out.println("End of the Method");
    }

    public static void main(String[] args) throws InterruptedException {
        incDecCountWithRunnableList();
    }
}