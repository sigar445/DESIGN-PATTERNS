package org.sigar.Annotations.MyAnnotation;
import java.lang.reflect.Field;

public class AnnotationProcessor {

    // Method to process annotations on a given object
    public static void validate(Object obj) throws IllegalAccessException {
        // Iterate through all fields of the object
        for (Field field : obj.getClass().getDeclaredFields()) {
            // Check if the field has the @ValidateString annotation
            if (field.isAnnotationPresent(ValidateString.class)) {
                // Make the private field accessible
                field.setAccessible(true);
                // Get the value of the field
                Object value = field.get(obj);

                // Validate the field's value
                if (value == null || ((String) value).isEmpty()) {
                    // Retrieve the annotation
                    ValidateString annotation = field.getAnnotation(ValidateString.class);
                    // Throw an exception with the custom message
                    throw new IllegalArgumentException(annotation.message());
                }
            }
        }
    }
}
