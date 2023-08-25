package com.sendingemails.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    private String className;
    private double feePaid;

}
