package com.demo.example.student_library_management.repository;

import com.demo.example.student_library_management.model.Book;
import com.demo.example.student_library_management.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
