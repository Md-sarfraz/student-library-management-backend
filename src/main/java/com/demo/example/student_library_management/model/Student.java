package com.demo.example.student_library_management.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
    @Column(nullable = false)
private String name;
    @Column(nullable = false)
private String email;
    @Column(nullable = false)
private String mobile;
    @Column(nullable = false)
private String dob;
    @Column(nullable = false)
private String gender;
    @Column(nullable = false)
private String dept;

    @JsonManagedReference
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Card card;
}
