package org.sigar.Concurrency.SemaphoreProducerConsumer;

import lombok.AllArgsConstructor;

import java.util.stream.IntStream;

@AllArgsConstructor
public class Producer implements Runnable {
    Q q;
    public void run() {
        IntStream.range(1,10).forEach(val -> q.put(val));
    }
}
