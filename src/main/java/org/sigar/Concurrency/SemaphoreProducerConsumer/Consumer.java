package org.sigar.Concurrency.SemaphoreProducerConsumer;

import lombok.AllArgsConstructor;

import java.util.stream.IntStream;

@AllArgsConstructor
public class Consumer implements Runnable{
    Q q;

    public void run(){
        IntStream.range(0,20).forEach(value -> q.get());
    }
}
