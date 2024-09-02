package org.sigar.examples.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppleMain {


    public static void main(String[] args) {
        List<Apple> appleList = fillAppleList();
       Comparator<Apple> appleComparator = Comparator
               .comparingDouble(Apple::getWeight)
               .thenComparing(Apple::getColor);
    //    appleList.sort(Comparator.comparingDouble(Apple::getWeight));
       appleList.sort(appleComparator);

       List<Apple> heavyAppleList = fillAppleList().stream()
               .filter((a)->a.getWeight()>10.0)
               .toList();
        heavyAppleList.forEach(a -> System.out.println(a.getColor()));
      //  System.out.println(appleList);
        appleList.forEach(a-> System.out.println(a.getWeight() + " " + a.getColor()));
    }

    private static List<Apple>  fillAppleList(){
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple(23.5,"blue"));
        appleList.add(new Apple(2.5,"green"));
        appleList.add(new Apple(28.5,"red"));
        appleList.add(new Apple(0.5,"yellow"));
        return appleList;

    }
}

