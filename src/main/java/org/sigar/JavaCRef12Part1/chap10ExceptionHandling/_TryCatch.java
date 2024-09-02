package org.sigar.JavaCRef12Part1.chap10ExceptionHandling;

public class _TryCatch<T> {
    public static void main(String[] args) {

//        _TryCatch<String> tryCatch = new _TryCatch<>();
   //     System.out.println(tryCatch.checkNull("sdfs"));

        try{
            int d = 0;
            int v = 10/d;
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }


    }
    public T checkNull(T object){

        if(object==null)
            throw new NullPointerException("Object is null");
       // Throwable throwable = new Exception("Exception ");
        return object;
    }

}
