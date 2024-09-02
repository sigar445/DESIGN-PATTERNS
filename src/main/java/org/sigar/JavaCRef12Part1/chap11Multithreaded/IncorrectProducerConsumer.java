package org.sigar.JavaCRef12Part1.chap11Multithreaded;

public class IncorrectProducerConsumer {

    static class Q{
        int n;
        synchronized int getN(){return n;};
        synchronized void putN(int num){
            System.out.println("Put: " + num);
            this.n=num;
        }
    }
    static class Producer implements Runnable{
        Q q;
        Thread t;
        Producer(Q q){
            this.q = q;
            t = new Thread(this,"Producer");
        }
        @Override
        public void run() {
            int val = 0;
            try {
                while (true) {
                    val++;
                    Thread.sleep(1000);
                    q.putN(val);
                }
            }catch (Exception e){
                System.out.println("Caught Exception " + e);
            }
        }
    }
    static class Consumer implements Runnable{
        Q q;
        Thread t;
        Consumer(Q q){
            this.q  = q;
            t = new Thread(this,"Consumer");
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    System.out.println("Consuming " + q.getN());
                }
            }catch (Exception e){
                System.out.println("Exception thrown " + e);
            }
        }
    }

    public static void main(String[] args) {
        Q q = new Q();
        //IncorrectProducerConsumer ipc = new IncorrectProducerConsumer();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);

        p.t.start();
        c.t.start();

    }
}
