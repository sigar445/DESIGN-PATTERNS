package org.sigar.InputOutput;

import java.io.File;
import java.util.Arrays;

public class OldDirectoryChecker {

    public static void main(String[] args) {
        showContents(".");
    }
    public  static void showContents(String uri){
        File directory = new File(uri);
        if(directory.isDirectory()){
            String[] contents = directory.list();
            assert contents != null;
            Arrays.stream(contents)
                    .forEach(System.out::println);
        }
    }
}
