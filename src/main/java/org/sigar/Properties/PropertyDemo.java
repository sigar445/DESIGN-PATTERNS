package org.sigar.Properties;

import java.io.*;
import java.util.Properties;

import static org.springframework.util.ClassUtils.getPackageName;

public class PropertyDemo {

    public static void readingPropertyFile(String fileName) throws FileNotFoundException {
        Properties properties = new Properties();

        File currentDir  = getCurrentDirUpdated(PropertyDemo.class);
        System.out.println("Directory Path " + currentDir.getAbsolutePath());
        File currFile = new File(currentDir, fileName);
         boolean fileStatus = currFile.isFile();
        System.out.println(currFile.isFile());
        try (FileInputStream fis = new FileInputStream(currFile)) {
            properties.load(fis);
            System.out.println(properties.getOrDefault("name1", "NO_KEY"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static File getCurrentDir(Class<?> clazz) {
        String currDir = System.getProperty("user.dir");
        String packageName = clazz.getPackage() == null ? "" : clazz.getPackageName();

        String packageDir = packageName.replace('.', File.separatorChar);

        return new File(currDir, packageDir);

    }
    public static File getCurrentDirUpdated(Class<?> clazz) {
        // Get the class's location in the file system
        String path = clazz.getProtectionDomain().getCodeSource().getLocation().getPath();

        // Decode %20 for spaces (if any)
        path = path.replace("%20", " ");

        // Create file object for the directory
        File dir = new File(path).getParentFile();  // Getting the parent directory (package location)
        return dir;
    }
    public static void readingPropertyFileUpdated(String fileName) throws IOException {
        Properties properties = new Properties();

        // Load the file using getResourceAsStream
        ClassLoader classLoader = PropertyDemo.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new FileNotFoundException("File not found: " + fileName);
        }

        try (inputStream)
        {
            properties.load(inputStream);
            System.out.println(properties.getOrDefault("name1", "NO_KEY"));
        }
    }
    public static String getFilePath(Class<?> clazz,String fileName){
        String packageName = clazz.getPackage() == null ? "" : clazz.getPackageName();

        String packageDir = packageName.replace('.', File.separatorChar);
        return new File(packageDir,fileName).getPath();
    }
    public static void readingPropertyFileUpdated2(String fileName) throws FileNotFoundException {
        Properties properties = new Properties();



        String currFilePath = getFilePath(PropertyDemo.class,fileName);
        System.out.println("path " + currFilePath);
//        File currFile = new File(currFilePath);
//        System.out.println(currFile);
//
//        if (!currFile.exists()) {
//            throw new FileNotFoundException("File not found: " + currFile.getAbsolutePath());
//        }

        try (FileInputStream fis = new FileInputStream(currFilePath)) {
            properties.load(fis);
            System.out.println(properties.getOrDefault("name1", "NO_KEY"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        String propertyFileName = "my_config.properties";
        String testFile = "Test.txt";
        File fileTest = new File("src/main/java/org/sigar/Properties/Test.txt");
        System.out.println(fileTest.isFile() ? fileTest.getPath() + " is a file" : "not a file");

        System.out.println(new File("org/sigar/Properties/Test.txt").getAbsolutePath());

        System.out.println(getFilePath(PropertyDemo.class,testFile));
        readingPropertyFileUpdated2(propertyFileName);
    }
}
