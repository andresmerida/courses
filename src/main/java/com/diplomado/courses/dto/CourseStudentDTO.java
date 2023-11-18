package com.diplomado.courses.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudentDTO {
    private String fullName;
    private String email;
    private Integer age;
    private String cardNumber;
    private Integer grade;
}
