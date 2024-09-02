package org.sigar.JavaCRef12Part2Lib.chapter22_IO;

import java.io.File;
import java.io.FilenameFilter;

public class FFObj implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        return false;
    }
}
