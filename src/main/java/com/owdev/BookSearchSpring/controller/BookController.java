package com.owdev.BookSearchSpring.controller;

import java.util.ArrayList;
import java.util.List;

import com.owdev.BookSearchSpring.domain.Book;
import com.owdev.BookSearchSpring.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookController {
    
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    
    @GetMapping("books")
    public List<Book> getBooks(){
        List<Book> books = bookService.findBooks();
        
        return books;
    }

    @PostMapping()
    public  List<Book> postBooks(@RequestBody List<Book>  books) {

        List<Book> results = new ArrayList<>();

        for (Book book : books) {                                   
            results.add(bookService.saveBook(book));
        }
        return results;

    }

    @PostMapping("search-books")
    public  List<Book> postSearchBooks(@RequestBody Book searchBook) {
                
        List<Book> results = bookService.searchBooks(searchBook.getTitle());
        
        return results;
    }
    

    @DeleteMapping()
    public void deleteBooks(@RequestBody List<Book>  books) {
        
        for (Book book : books) {                                   
            bookService.deleteOne(book.getId());
        }
        return;

    }
}
