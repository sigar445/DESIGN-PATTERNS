package org.sigar.Generics;


import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class GenericMethods<T extends  Number> {
    T[] elements;

}
