package org.sigar.Annotations.MyAnnotation;

public class AnnotationDemo {
    public static void main(String[] args) throws IllegalAccessException {
        User emptyUser = new User("");
        try {
            AnnotationProcessor.validate(emptyUser); // Process the annotations on the user object
        } catch (IllegalArgumentException | IllegalAccessException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

    }
}
