package org.sigar.examples;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@AllArgsConstructor
@Getter
class Person {
    private String name;
    private int age;
    private double height;

    // Constructor, getters, and setters


    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Alice", 30, 5.4));
        people.add(new Person("Bob", 25, 5.8));
        people.add(new Person("Charlie", 25, 5.6));


        Comparator<Person> comparatorOld = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int ageComparison = Integer.compare(p1.getAge(), p2.getAge());
                if (ageComparison != 0) {
                    return ageComparison;
                } else {
                    return Double.compare(p1.getHeight(), p2.getHeight());
                }
            }
        };

//        // Sort by age, then by height
//        Comparator<Person> comparator =Comparator
//                .comparingInt(Person::getAge)
//                .thenComparingDouble(Person::getHeight);
//
//        people.sort(comparatorOld);

        Comparator<Person> personComparator = Comparator
                .comparingInt(Person::getAge)
                .thenComparingDouble(Person::getHeight);
        people.sort(personComparator);
        for (Person person : people) {
            System.out.println(person.getName() + " " + person.getAge() + " " + person.getHeight());
        }
    }
}
