package com.owdev.BookSearchSpring.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "AMAZON_BOOK")
public class AmazonBook {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="TITLE")
    private String title;

    @Column(name="AUTHOR")
    private String author;

    @Column(name="PRICE")
    private Double price;

    @Column(name="ISBN")
    private String isbn;
    
}
