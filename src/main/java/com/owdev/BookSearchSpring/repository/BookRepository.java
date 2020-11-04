package com.owdev.BookSearchSpring.repository;

import java.util.List;
import java.util.Optional;
import com.owdev.BookSearchSpring.domain.Book;

public interface BookRepository {
    Optional<Book> findById(Long id);
    Optional<Book> findByTitle(String title);
    List<Book> findAll();
}
