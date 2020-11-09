package com.owdev.BookSearchSpring.repository;

import com.owdev.BookSearchSpring.domain.AmazonBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAmazonBookRepository extends JpaRepository<AmazonBook, Long>, AmazonBookRepository {
    
}
