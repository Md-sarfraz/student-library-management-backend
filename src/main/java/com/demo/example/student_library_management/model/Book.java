package com.demo.example.student_library_management.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
    @Column(name = "book_Title")
private String title;
    @Column(name = "book_Pages")
private int pages;
    @Column(name = "publisher_name")
private String publisherName;
    @Column
    private String genre;
    @Column(name = "available_book")
private boolean available;

    @ManyToOne
    @JoinColumn
    private Author author;

    @JoinColumn
    @ManyToOne
    private Card card;

    @OneToMany(mappedBy ="book",cascade = CascadeType.ALL)
    private List<Transaction>transactionsOfBook=new ArrayList<Transaction>();
}
