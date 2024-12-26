package com.demo.example.student_library_management.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
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
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Card card;
}
