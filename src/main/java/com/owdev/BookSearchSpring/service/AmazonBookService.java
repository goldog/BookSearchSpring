package com.owdev.BookSearchSpring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.owdev.BookSearchSpring.domain.AmazonBook;
import com.owdev.BookSearchSpring.repository.AmazonBookRepository;

@Transactional
public class AmazonBookService {

    private final AmazonBookRepository bookRepository;

	public AmazonBookService(AmazonBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<AmazonBook> findBooks() {
		return bookRepository.findAll();
	}

	public Optional<AmazonBook> findOne(Long id) {
		return bookRepository.findById(id);
	}

	public AmazonBook saveBook(AmazonBook book) {
		return bookRepository.save(book); 
	}

	public void deleteOne(Long id) {
		bookRepository.deleteById(id);
	}

	public List<AmazonBook> findBooksByTitle(String title) {
		return bookRepository.findByTitleContainingIgnoreCase(title);
	}

	public Optional<AmazonBook> findBooksByIsbn(String isbn) {
		return bookRepository.findByIsbn(isbn);
	}
    
}
