package com.owdev.BookSearchSpring.repository;

import java.util.List;
import java.util.Optional;

import com.owdev.BookSearchSpring.domain.DomesticBook;

public interface DomesticBookRepository {
    DomesticBook save(DomesticBook book);
    Optional<DomesticBook> findById(Long id);
    Optional<DomesticBook> findByTitle(String title);
    List<DomesticBook> findAll();
    void deleteById(Long id);
    
}