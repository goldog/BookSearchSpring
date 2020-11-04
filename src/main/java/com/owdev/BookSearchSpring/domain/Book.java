package com.owdev.BookSearchSpring.domain;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="TITLE")
    private String title;

    @Column(name="AUTHOR")
    private String author;

    @Column(name="KOR_PRICE")
    private Long korPrice;

    @Column(name="USA_PRICE")
    private Double usaPrice;

    @Column(name="ISBN")
    private String isbn;


    
}
