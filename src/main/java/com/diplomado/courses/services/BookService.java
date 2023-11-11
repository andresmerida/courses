package com.diplomado.courses.services;

import com.diplomado.courses.domain.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooksByStudent(Integer studentId);
    Book save(Book book);
}
