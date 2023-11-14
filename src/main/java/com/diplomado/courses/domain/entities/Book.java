package com.diplomado.courses.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @SequenceGenerator(name = "book_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    private Integer id;
    private String name;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    public Book(String name, LocalDateTime createdAt, Student student) {
        this.name = name;
        this.student = student;
        this.createdAt = createdAt;
    }

    public Book() {
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", student=" + student +
                '}';
    }
}
