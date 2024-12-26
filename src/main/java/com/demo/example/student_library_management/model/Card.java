package com.demo.example.student_library_management.model;

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
    @OneToOne
    @JoinColumn
    private Student student;
    @OneToMany(mappedBy="card",cascade=CascadeType.ALL)
    List<Book>bookIssuedToCard = new ArrayList<>();

    @OneToMany(mappedBy="card",cascade=CascadeType.ALL)
    private List<Transaction>transactionByCard=new ArrayList<>();

}
