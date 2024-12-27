package com.demo.example.student_library_management.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "author")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;
    @Column(name = "author_name")
    private String name;
    @Column(name = "author_email")
    private String email;
    @Column
    private String country;
    @Column
    private String rating;

    @JsonManagedReference
@OneToMany(mappedBy = "author", cascade= CascadeType.ALL)
    private List<Book> bookByAuthor= new ArrayList<>();


//    mappedBY=@JsonManagedReference
  //  joinColumn=@JsonBackReference
    // whenever use mappedBy than use JsonManagedReference annotation
    // whenever use joinColumn than use JsonBackReference annotation
}
