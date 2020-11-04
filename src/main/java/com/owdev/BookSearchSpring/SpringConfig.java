package com.owdev.BookSearchSpring;

import com.owdev.BookSearchSpring.repository.BookRepository;
import com.owdev.BookSearchSpring.service.BookService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    
    private final BookRepository bookRepository;

    public SpringConfig(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Bean
    public BookService bookService() {
        return new BookService(bookRepository);
    }
}
