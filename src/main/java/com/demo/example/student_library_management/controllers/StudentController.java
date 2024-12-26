package com.demo.example.student_library_management.controllers;

import com.demo.example.student_library_management.requestDto.StudentRequestDto;
import com.demo.example.student_library_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student/apis")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/save")
public String saveStudent(StudentRequestDto studentRequestDto) {
        String student= studentService.addStudent(studentRequestDto);
        return student;
}
}
