package org.sigar.JavaCRef12Part1.chap6Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class _Protected {
    // It has package-level access and all it can be accessed by extended class
    protected int protectedVal;
}
