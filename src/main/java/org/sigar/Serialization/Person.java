package org.sigar.Serialization;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private Integer age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
