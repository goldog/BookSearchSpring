package com.owdev.BookSearchSpring.controller;

import java.util.List;

import com.owdev.BookSearchSpring.domain.Book;
import com.owdev.BookSearchSpring.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    
    @GetMapping("books")
    public String getBooks(){
        List<Book> books = bookService.findBooks();

        return books.get(0).toString();
    }
}
