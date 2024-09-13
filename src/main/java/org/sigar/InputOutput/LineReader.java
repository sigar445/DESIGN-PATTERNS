package org.sigar.InputOutput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class LineReader {

    public static void main(String[] args) throws IOException {
        System.out.println("Current working directory " + System.getProperty("user.dir"));
        String fileName = "stuff.txt";
        readFileByLines(fileName);
        modernReadFileByLines(fileName);
    }
    public static void readFileByLines(String filename){
        try (InputStream fileInputStream = new FileInputStream(filename)){
            Reader intReader = new InputStreamReader(fileInputStream);
            LineNumberReader lineNumberReader = new LineNumberReader(intReader);
            lineNumberReader.lines().forEach(line -> System.out.println(lineNumberReader.getLineNumber() + "  " + line));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void modernReadFileByLines(String filename) throws IOException {
        Path path = Path.of(filename);
        try (var lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        }
    }

}
