package org.sigar.JavaCRef12Part1.chap2Variables;

public class _TypeConversion {

    public static void main(String[] args) {
        double doubleVal = 34.5;
       // int x = doubleVal; invalid biggest bytes to smaller bytes cast not allowed
        double smallDouble  = 23;

        //If double values can be fitted in int , type casting can be done
        //forceful casting
        int x = (int) smallDouble;
        System.out.println(x);

        //A different type of conversion will occur when a floating-point value is
        //assigned to an integer type: truncation.
        //only first 32 bits will be taken
        int y = (int) doubleVal;
        System.out.println(y);

        // If the integer’s
        //value is larger than the range of a byte, it will be reduced modulo (the
        //remainder of an integer division by the) byte’s range
        int z = 263;
        byte bVal = (byte) z;
        System.out.println(bVal);


        //truncation, ignoring fraction values
        bVal = (byte) doubleVal;
        System.out.println(bVal);

        byte a = 40;
        byte b = 50;
        byte c = 100;
        int d = a * b / c;
        //Java automatically
        //promotes each byte, short, or char operand to int when evaluating an
        //expression. This means that the subexpression a*b is performed using integers
        //—not bytes. Thus, 2,000, the result of the intermediate expression, 50 * 40, is
        //legal even though a and b are both specified as type byte.
        System.out.println(d);

       // b = b*2;  invalid
        b = (byte) (b * 2); //valid

    }
}
