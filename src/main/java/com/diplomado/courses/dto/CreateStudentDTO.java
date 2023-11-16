package com.diplomado.courses.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateStudentDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}
