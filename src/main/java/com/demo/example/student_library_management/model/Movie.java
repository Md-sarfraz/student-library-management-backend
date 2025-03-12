package com.demo.example.student_library_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;
//import jakarta.validation.constraints.Pattern;


import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@ToString
public class Movie {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Column
//    @NotBlank(message = "title is required")
    private String title;

    @Column
    private String description;

    @Column
    private String genre;

    @Column
    private String format;

    @Column
    private String duration;

    @Column
    private String language;

    @Column
    private String releaseDate;

    @Column
    private String postUrl;

    @Column
    private String rating;
    @Column

    private String director;

    private String trailer;

}
