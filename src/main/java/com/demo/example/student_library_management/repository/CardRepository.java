package com.demo.example.student_library_management.repository;

import com.demo.example.student_library_management.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
