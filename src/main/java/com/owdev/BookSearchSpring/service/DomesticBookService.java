package com.owdev.BookSearchSpring.service;

import java.util.List;
import java.util.Optional;

import com.owdev.BookSearchSpring.domain.DomesticBook;
import com.owdev.BookSearchSpring.repository.DomesticBookRepository;

public class DomesticBookService {

    private final DomesticBookRepository bookRepository;

	public DomesticBookService(DomesticBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<DomesticBook> findBooks() {
		return bookRepository.findAll();
	}

	public Optional<DomesticBook> findOne(Long id) {
		return bookRepository.findById(id);
	}
	public Optional<DomesticBook> findOneByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

	public DomesticBook saveBook(DomesticBook book) {
		return bookRepository.save(book); 
	}

	public void deleteOne(Long id) {
		bookRepository.deleteById(id);
	}
    
}
