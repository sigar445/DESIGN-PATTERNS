package org.sigar.JavaCRef12Part1.chap12AutoBoxingAnnotationsAndEnums;

public class EnumDemo2 {
    enum Apple{
        Jonathan(10), GoldenDel(9), RedDel, Winesap(15), Cortland(8);
        int price;
        Apple(int price){
            this.price = price;
        }
        Apple(){price = -1;}
        int getPrice(){return price;}
    }

    public static void main(String[] args) {
        System.out.println("Winesap costs "+ Apple.Winesap.getPrice());
        for(Apple ap : Apple.values()){
            System.out.println(ap + " " + ap.getPrice());
        }
        for(Apple a : Apple.values())
            System.out.println(a + " " + a.ordinal());

    }
}
