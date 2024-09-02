package org.sigar.JavaCRef12Part2Lib.chap21_java_util;

import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

public class DateTimeFormat {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Formatter fmt  = new Formatter();

        fmt.format("%tr",cal);
        System.out.println(cal);
        fmt.close();


        fmt = new Formatter();
        fmt.format("%tc", cal);
        System.out.println(fmt);
        fmt.close();
        // Display just hour and minute.
        fmt = new Formatter();
        fmt.format("%tl:%tM", cal, cal);
        System.out.println(fmt);
        fmt.close();
        // Display month by name and number.
        fmt = new Formatter();
        fmt.format("%tB %tb %tm", cal, cal, cal);
        System.out.println(fmt);
        fmt.close();

         fmt = new Formatter();
            fmt.format("Copying file%nTransfer is %d%% complete", 88);
            System.out.println(fmt);
            fmt.close();

            fmt = new Formatter();
        fmt.format("|%f|%n|%12f|%n|%012f|",
                10.12345, 10.12345, 10.12345);
        System.out.println(fmt);
        fieldWidthImp();
        precisionWidthImp();

    }
    public static void fieldWidthImp(){
        Formatter fmt;
        for(int i=1; i <= 10; i++) {
            fmt = new Formatter();
            fmt.format("%4d %4d %4d", i, i*i, i*i*i);
            System.out.println(fmt);
            fmt.close();
        }
    }
    public static void precisionWidthImp() {
        Formatter fmt = new Formatter();
        // Format 4 decimal places.
        fmt.format("%.4f", 123.1234567);
        System.out.println(fmt);
        fmt.close();
        // Format to 2 decimal places in a 16 character field
        fmt = new Formatter();
        fmt.format("%16.2e", 123.1234567);
        System.out.println(fmt);
        fmt.close();
        // Display at most 15 characters in a string.
        fmt = new Formatter();
        fmt.format("%.15s", "Formatting with Java is now easy.");
        System.out.println(fmt);
        fmt.close();
    }
}
