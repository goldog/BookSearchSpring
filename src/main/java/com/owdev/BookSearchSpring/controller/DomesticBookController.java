package com.owdev.BookSearchSpring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.owdev.BookSearchSpring.domain.DomesticBook;
import com.owdev.BookSearchSpring.service.DomesticBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/domestic")
public class DomesticBookController {
    private final DomesticBookService bookService;
    
    @Autowired
    public DomesticBookController (DomesticBookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("books")
    public List<DomesticBook> getBooks() {
        List<DomesticBook> books = bookService.findBooks();
        
        return books;
    }

    @PostMapping("search-books")
    public  Optional<DomesticBook> postSearchBooks(@RequestBody DomesticBook searchBook) {
         
        if (searchBook.getIsbn() != null && searchBook.getIsbn() != "" ) {
            return bookService.findBooksByIsbn(searchBook.getIsbn());     

        }
        else {
            return Optional.empty();
        }
    }
}
