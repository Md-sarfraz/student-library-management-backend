package com.demo.example.student_library_management.repository;

import com.demo.example.student_library_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    // customised queries(write own custom queries)
    public Student findByEmail(String email);
    public List<Student> findByDept(String dept);
    public Student findByEmailAndDept(String email, String dept);
    public List<Student> findByEmailOrDept(String email, String Dept);

}
