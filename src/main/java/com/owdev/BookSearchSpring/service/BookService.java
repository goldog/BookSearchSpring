package com.owdev.BookSearchSpring.service;

import java.util.List;
import java.util.Optional;

import com.owdev.BookSearchSpring.domain.Book;
import com.owdev.BookSearchSpring.repository.BookRepository;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BookService {

    private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
	}
	
	public List<Book> findBooks() {
		return bookRepository.findAll();
	}

	public Optional<Book> findOne(Long id) {
		return bookRepository.findById(id);
	}
	public Optional<Book> findOne(String title) {
		return bookRepository.findByTitle(title);
	}

	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	public void deleteOne(Long id) {
		bookRepository.deleteById(id);
	}
	
}
