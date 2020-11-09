package com.owdev.BookSearchSpring;

import com.owdev.BookSearchSpring.repository.AmazonBookRepository;
import com.owdev.BookSearchSpring.repository.BookRepository;
import com.owdev.BookSearchSpring.service.AmazonBookService;
import com.owdev.BookSearchSpring.service.BookService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    
    private final BookRepository bookRepository;
    private final AmazonBookRepository amazonBookRepository;

    public SpringConfig(BookRepository bookRepository, 
    AmazonBookRepository amazonBookRepository) {
        this.bookRepository = bookRepository;
        this.amazonBookRepository = amazonBookRepository;
    }

    @Bean
    public BookService bookService() {
        return new BookService(bookRepository);
    }

    @Bean
    public AmazonBookService amazonBookService() {
        return new AmazonBookService(amazonBookRepository);
    }

}
