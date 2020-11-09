package com.owdev.BookSearchSpring.controller;

import java.util.ArrayList;
import java.util.List;

import com.owdev.BookSearchSpring.domain.AmazonBook;
import com.owdev.BookSearchSpring.service.AmazonBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/amazon")
public class AmazonBookController {
    
    private final AmazonBookService bookService;

    @Autowired
    public AmazonBookController (AmazonBookService bookService){
        this.bookService = bookService;
    }
    
    @GetMapping("books")
    public List<AmazonBook> getBooks() {
        List<AmazonBook> books = bookService.findBooks();
        
        return books;
    }

    @PostMapping("search-books")
    public  List<AmazonBook> postSearchBooks(@RequestBody AmazonBook searchBook) {
        
        List<AmazonBook> results = new ArrayList<>();
         
        if (searchBook.getTitle() != null && searchBook.getTitle() != "" ) {
            results = bookService.findBooksByTitle(searchBook.getTitle());
        }
        else if (searchBook.getIsbn() != null && searchBook.getIsbn() != "" ) {      
            AmazonBook result = bookService.findBooksByIsbn(searchBook.getIsbn()).orElseGet(null);           

            results.add(result);
        }   
        
        return results;
    }
}
