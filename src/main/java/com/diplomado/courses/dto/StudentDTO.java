package com.diplomado.courses.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;

    private String cardNumber;

    public StudentDTO() {
    }
}
