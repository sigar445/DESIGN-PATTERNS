package org.sigar.Annotations.MyAnnotation;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
  //  @ValidateString(message = "Name cannot be empty") // Applying the custom annotation
    @ValidateString
    private String name;

}
