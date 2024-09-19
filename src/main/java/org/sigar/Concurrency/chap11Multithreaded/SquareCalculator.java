package org.sigar.Concurrency.chap11Multithreaded;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SquareCalculator implements Runnable{
    int num;
    @Override
    public void run() {

        int square = num * num;
        System.out.println(Thread.currentThread().getName() + " - Sqaure of "
                + num + " is " + square);
    }
    public SquareCalculator(int number){
        num = number;
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);


        for (int i = 0; i < 10; i++) {
                service.submit(new SquareCalculator(i));
        }
        service.shutdown();
    }
}
