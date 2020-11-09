package com.owdev.BookSearchSpring.repository;

//import java.util.Optional;

import com.owdev.BookSearchSpring.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookRepository extends JpaRepository<Book, Long>, BookRepository{
    
    // @Override
    // Optional<Book> findByTitle(String title);
}
