package com.demo.example.student_library_management.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
private int id;
    @Column(name = "transaction_status")
private String transactionStatus;
    @Column(name = "transaction_date")
    @CreationTimestamp
private Date transactionDate;
    @Column(name = "due_Date")
private String dueDate;
    @Column(name = "fine")
private double fine;
    @Column(name = "issue_or_return")
    private String issueOrReturn;
    @JoinColumn
    @ManyToOne
    private Card card;
    @JoinColumn
    @ManyToOne
    private Book book;
}
