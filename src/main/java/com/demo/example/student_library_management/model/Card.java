package com.demo.example.student_library_management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="card")
@Data
public class Card {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "card_status",nullable = false)
    private String cardStatus;

    @CreationTimestamp
    @Column(name = "create_date",nullable = false)
    private Date createDate;

    @Column(name = "update_date",nullable = false)
    @UpdateTimestamp
    private Date updateDate;

    @JsonBackReference
    @OneToOne
    @JoinColumn
    private Student student;
    @OneToMany(mappedBy="card",cascade=CascadeType.ALL)
    List<Book>bookIssuedToCard = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy="card",cascade=CascadeType.ALL)
    private List<Transaction>transactionByCard=new ArrayList<>();

}
