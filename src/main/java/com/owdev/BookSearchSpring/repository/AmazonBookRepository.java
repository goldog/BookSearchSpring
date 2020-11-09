package com.owdev.BookSearchSpring.repository;

import java.util.List;
import java.util.Optional;

import com.owdev.BookSearchSpring.domain.AmazonBook;

public interface AmazonBookRepository {
    AmazonBook save(AmazonBook book);
    Optional<AmazonBook> findById(Long id);
    List<AmazonBook> findAll();
    void deleteById(Long id);
    List<AmazonBook> findByTitleContainingIgnoreCase(String title);
    Optional<AmazonBook> findByIsbn(String isbn);
}
