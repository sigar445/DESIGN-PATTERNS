package org.sigar.JavaCRef12Part1.chap11Multithreaded;

public class CorrectProducerConsumer {

    static class Q{
        int n;
        boolean signal = false;
        synchronized int getN() {
            while (!signal) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Caught " + e);
                }
            }
                System.out.println("Got: " + n);
                signal = false;
                notify();
                return n;
            }

        synchronized void putN(int num){
            while (signal) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Caught " + e);
                }
            }
            signal  = true;
            System.out.println("Put: " + num);
            this.n=num;
            notify();
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


