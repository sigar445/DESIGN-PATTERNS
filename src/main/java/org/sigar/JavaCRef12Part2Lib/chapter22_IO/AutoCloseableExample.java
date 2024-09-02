package org.sigar.JavaCRef12Part2Lib.chapter22_IO;

public class AutoCloseableExample {

    public static class MyResource implements AutoCloseable{

        @Override
        public void close() throws Exception {
            System.out.println("Closing new resource");
        }

        public void useResource(){
            System.out.println("Using resource");
        }

        public static void main(String[] args) throws Exception {
            try(MyResource resource = new MyResource()){
                resource.useResource();
            }
        }
    }
}
