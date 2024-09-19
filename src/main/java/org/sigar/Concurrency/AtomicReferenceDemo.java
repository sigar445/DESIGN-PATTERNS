package org.sigar.Concurrency;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
    private static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " (Age: " + age + ")";
        }
    }

    private final AtomicReference<Person> atomicPerson = new AtomicReference<>(new Person("John", 30));

    public void updatePerson(String name, int age) {
        Person newPerson = new Person(name, age);
        atomicPerson.set(newPerson); // Atomically set the new person object
        System.out.println("Updated person: " + atomicPerson.get());
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicReferenceDemo example = new AtomicReferenceDemo();
        List<Callable<Object>> callableList = List.of(
               Executors.callable(()->example.updatePerson("John", 45)),
               Executors.callable(()->example.updatePerson("Tom", 21)),
                Executors.callable(()->example.updatePerson("John", 41))

                );
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.invokeAll(callableList);
    }
}
