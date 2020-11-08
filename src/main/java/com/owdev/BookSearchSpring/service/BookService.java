package com.owdev.BookSearchSpring.service;

import java.util.List;
import java.util.Optional;

import com.owdev.BookSearchSpring.domain.Book;
import com.owdev.BookSearchSpring.repository.BookRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
	
	@Deprecated
	public List<Book> searchBooks(String searchKeyword) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\goldog\\Downloads\\chromedriver.exe");
		WebDriver driver = null;

		ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
		options.addArguments("lang=en-us");
		options.addArguments("disable-gpu");
		options.addArguments("window-size=1920x1080");
		options.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
		//options.addArguments("profile.default_content_setting_values.images", 2);
	
		driver = new ChromeDriver(options);
		
		String url = "https://www.amazon.com/";
		
		driver.get(url);
		driver.quit();
		return bookRepository.findAll();
	}
	
}
