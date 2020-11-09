package com.owdev.BookSearchSpring.repository;

import com.owdev.BookSearchSpring.domain.DomesticBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDomesticBookRepository extends JpaRepository<DomesticBook, Long>, DomesticBookRepository{
    
}
