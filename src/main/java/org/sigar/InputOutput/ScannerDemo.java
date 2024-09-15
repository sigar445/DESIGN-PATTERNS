package org.sigar.InputOutput;
import java.io.*;
import java.util.*;
public class ScannerDemo {
    public static void scannerBasics() throws FileNotFoundException {
        String instr = "10 99.88 scanning is easy.";
        Scanner sc = new Scanner(instr);
        while (sc.hasNext()) System.out.println(sc.nextLine());

        FileReader fin = new FileReader("stuff.txt");
        Scanner src = new Scanner(fin);
        while (src.hasNext()) System.out.println(src.nextLine());
    }
    public static void average() throws FileNotFoundException {
        int count = 0;
        double sum = 0.0;
        // Write output to a file.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"))) {
            writer.write("2 3.4 5 6 7.4 9.1 10.5 done");
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileReader fin = new FileReader("Test.txt");
        Scanner src = new Scanner(fin);
        // Read and sum numbers.
        while(src.hasNext()) {
            if(src.hasNextDouble()) {
                sum += src.nextDouble();
                count++;
            }
            else {
                String str = src.next();
                if(str.equals("done")) break;
                else {
                    System.out.println("File format error.");
                    return;
                }
            }
        }
        src.close();
        System.out.println("Average is " + sum / count);
    }
    public static void deLimiter() throws FileNotFoundException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"))) {
            writer.write("2, 3.4, 5, 6, 7.4, 9.1, 10.5");
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileReader fin = new FileReader("Test.txt");
        Scanner src = new Scanner(fin);
        src.useDelimiter(", ");
        while (src.hasNextDouble()) System.out.println(src.next());
    }

    public static void nextInLine(){
        Scanner conin = new Scanner("Name: Tom Age: 28 ID: 77");
        conin.findInLine("Age:"); // find Age
        if(conin.hasNext())
            System.out.println(conin.next());
        else
            System.out.println("Error!");
        conin.close();
    }


public static void main(String[] args) throws FileNotFoundException {
        //scannerBasics();
        //average();
        //deLimiter();
        nextInLine();
    }
}
