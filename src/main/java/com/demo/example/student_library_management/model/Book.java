package com.demo.example.student_library_management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Author author;

    @JsonBackReference
    @JoinColumn
    @ManyToOne
    private Card card;

    @JsonManagedReference
    @OneToMany(mappedBy ="book",cascade = CascadeType.ALL)
    private List<Transaction>transactionsOfBook=new ArrayList<Transaction>();
}
