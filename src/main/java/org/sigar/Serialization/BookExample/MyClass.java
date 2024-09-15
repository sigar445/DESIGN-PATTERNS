package org.sigar.Serialization.BookExample;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public  class MyClass implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;
    private int number;
    private double largeNumber;

    public MyClass(String message, int number, double largeNumber) {
        this.message = message;
        this.number = number;
        this.largeNumber = largeNumber;
    }

    @Override
    public String toString() {
        return "MyClass [message=" + message + ", number=" + number + ", largeNumber=" + largeNumber + "]";
    }
}

