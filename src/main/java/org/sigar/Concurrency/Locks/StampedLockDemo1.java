package org.sigar.Concurrency.Locks;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo1 {
        private final StampedLock lock = new StampedLock();
        private int count;

        public int increment() {
            long stamp = lock.writeLock();
            try {
                count++;
                return count;
            } finally {
                lock.unlock(stamp);
            }
        }

        public int getCount() {
            long stamp = lock.tryOptimisticRead();
            int currentCount = count;
            if (!lock.validate(stamp)) {
                stamp = lock.readLock();
                try {
                    currentCount = count;
                } finally {
                    lock.unlock(stamp);
                }
            }
            return currentCount;
        }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        StampedLockDemo1 demo1 = new StampedLockDemo1();
        Callable<Integer> reader = demo1::getCount;
        Callable<Integer> writer = demo1::increment;
        ExecutorService service = Executors.newFixedThreadPool(2);

        List<Callable<Integer>> callableList = List.of(reader,
                writer,
                reader,
                writer,
                reader,
                reader);

        List<Future<Integer> > values = service.invokeAll(callableList);
        for (Future<Integer> future : values){
            System.out.println(future.get());
        }

       }
}
