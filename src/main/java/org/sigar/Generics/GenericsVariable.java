package org.sigar.Generics;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public class GenericsVariable<T extends Number> {


    private T value;


}
