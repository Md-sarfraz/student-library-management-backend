package com.demo.example.student_library_management.controllers;

import com.demo.example.student_library_management.model.Student;
import com.demo.example.student_library_management.requestDto.StudentRequestDto;
import com.demo.example.student_library_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("student/apis")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/save")
public String saveStudent(@RequestBody StudentRequestDto studentRequestDto) {
        String response = studentService.addStudent(studentRequestDto);
        return response;
}
@GetMapping("/find/{id}")
public Optional<Student> findStudentById(@PathVariable int id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student;
}
}
