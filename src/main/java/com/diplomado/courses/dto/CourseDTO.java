package com.diplomado.courses.dto;

import java.io.Serializable;

public class CourseDTO implements Serializable {

    private static final long serialVersionUID = 8799656478674712000L;
    private Integer id;
    private String name;
    private String department;

    public CourseDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
