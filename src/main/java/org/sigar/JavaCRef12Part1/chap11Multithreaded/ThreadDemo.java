package org.sigar.JavaCRef12Part1.chap11Multithreaded;

public class ThreadDemo {
    public static void main(String[] args) {

        Thread thread1 = new NewThread();
        thread1.setName("thread1");

        Thread thread2 = new NewThread();
        thread2.setName("thread2");
        Thread thread3 = new Thread(new RunnableNewThread(),"thread3");
        thread3.start();
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        }catch (InterruptedException e){
            System.out.println(e);
        }

    }

}
