package com.demo.example.student_library_management.repository;
import com.demo.example.student_library_management.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
