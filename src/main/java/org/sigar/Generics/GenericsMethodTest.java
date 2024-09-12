package org.sigar.Generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenericsMethodTest {


    public static void main(String[] args) {

        List<String> list = new LinkedList<>();
        checkType(list);

    }
    public static <T> void checkType(T list) {
        // Reflection to get the generic type of T, works well when used with classes
        Type[] genericInterfaces = list.getClass().getGenericInterfaces();

        for (Type genericInterface : genericInterfaces) {
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
                System.out.println("Parameterized type: " + parameterizedType);
            }
        }
    }
}
