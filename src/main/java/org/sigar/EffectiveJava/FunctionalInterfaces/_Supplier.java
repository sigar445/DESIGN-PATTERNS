package org.sigar.EffectiveJava.FunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

import static org.sigar.EffectiveJava.FunctionalInterfaces.Person.Gender.MALE;

public class _Supplier {
    public static void main(String[] args) {
        Supplier<Person> personSupplier = ()-> new Person("rqwram", MALE,93);

        personSupplier.get();

        List<Person> people = new ArrayList<>(Constants.personList);
        people.add(personSupplier.get());
        people.forEach(System.out::println);
        
    }
}
