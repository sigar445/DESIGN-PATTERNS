package org.sigar.JavaCRef12Part1.chap13_IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class ReadFileWithFiles {

    public static void main(String[] args) {
        readFile();
    }
    public static void readFile() {
        System.out.print("Enter the file name (with path if not in the current directory): ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        try(Stream<String> lines = Files.lines(Paths.get(fileName))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
