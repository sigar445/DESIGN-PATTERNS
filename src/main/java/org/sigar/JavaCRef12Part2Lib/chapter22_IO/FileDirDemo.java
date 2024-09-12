package org.sigar.JavaCRef12Part2Lib.chapter22_IO;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public class FileDirDemo {
    public static void main(String[] args) {

        File curr_dir = getCurrentDir();
        //filterWithFileNameFilter(curr_dir, "temp");
        filterWithFileFilter(curr_dir,"filter");
    }

    public static File getCurrentDir() {
        String curr_dir = System.getProperty("user.dir");
        String package_name = FileDirDemo.class.getPackage() == null ? "" : FileDirDemo.class.getPackageName();

        String package_dir = package_name.replace('.', File.separatorChar);

        File file_dir = new File(curr_dir, package_dir);
        file_dir.mkdirs();
        File dir = new File(file_dir, "/directoryNew");
        dir.mkdir();

        return dir;
    }

    static public void createFiles(String dir) {
//        File file = new File(file_dir,"fileList");
        for (int ind = 0; ind < 5; ind++) {
            File fileInd = new File(dir, "variable" + String.valueOf(ind));
            addData(fileInd);
        }

    }

    static void addData(File file) {

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter buffWriter = new BufferedWriter(fileWriter)) {
            buffWriter.write("Hello , File is ready to write\n");
            buffWriter.write("Sentence 1\n");
            buffWriter.write("Sentence 2\n");
            buffWriter.write("Sentence 3\n");
            buffWriter.write("Sentence 4\n");
            buffWriter.write("Sentence 5\n");
            buffWriter.write("Sentence 6\n");
            buffWriter.write("Sentence 7");

            System.out.println(file.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void listFiles() {
        String root_dir = System.getProperty("user.dir");

        String package_name = FileDirDemo.class.getPackage() == null ? "" : FileDirDemo.class.getPackageName();
        String package_dir = package_name.replace('.', File.separatorChar);

        File package_dir_file = new File(root_dir, package_dir);
        File new_dir = new File(package_dir_file, "/dir");
        System.out.println(new_dir.isDirectory());
        if (new_dir.isDirectory()) {
            File child_dir = new File(package_dir_file, "/child");
            child_dir.mkdirs();
            System.out.println(child_dir.isDirectory());
            String[] files = new_dir.list();
            assert files != null;
            Arrays.stream(files).forEach(System.out::println);
        }
    }
    static void filterDemo1(File file_dir, String filter_string) {
        System.out.println(filter_string + " = filter_string, path = " + file_dir.getPath());

        FilenameFilter file_filter = (dir, name) -> name.contains(filter_string);

        File[] filteredFiles = file_dir.listFiles(file_filter);

        if (filteredFiles != null) {
            Arrays.stream(filteredFiles).forEach(System.out::println);
        } else {
            System.out.println("No files found.");
        }
    }

    static void filterWithFileNameFilter(File file_dir,String filterString) {
        System.out.println(filterString + " = filter_string , path = " + file_dir.getPath());
      //  Arrays.stream(file_dir.listFiles()).forEach(file -> System.out.println(file.getFirstName()));
        FilenameFilter file_filter = (dir,name) -> name.contains(filterString);
        File[] files = file_dir.listFiles(file_filter);
        if(files != null) {
            Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
        }else {
            System.out.println("No files found or an error occurred");
        }
    }
    static void filterWithFileFilter(File file_dir, String filterString){

        FileFilter fileFilter = (f)-> f.getName().contains(filterString);
        File[] files = file_dir.listFiles(fileFilter);
        Arrays.stream(files).forEach(System.out::println);

    }

}
