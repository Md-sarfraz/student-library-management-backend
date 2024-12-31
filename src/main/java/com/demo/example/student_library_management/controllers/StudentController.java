package com.demo.example.student_library_management.controllers;

import com.demo.example.student_library_management.model.Student;
import com.demo.example.student_library_management.requestDto.StudentRequestDto;
import com.demo.example.student_library_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student/apis")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody StudentRequestDto studentRequestDto) {
        try {
            String response = studentService.addStudent(studentRequestDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable int id) {
        try {
            Optional<Student> student = studentService.getStudentById(id);
            return ResponseEntity.ok(student);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllStudent() {
        try {
            List<Student> students = studentService.getAllStudent();
            return ResponseEntity.ok(students);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/count")
    public ResponseEntity<?> countStudent() {
        try {
            String response = studentService.getStudentCount();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable int id) {
        try {
            String response = studentService.deleteStudentById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudentById(@PathVariable int id, @RequestBody StudentRequestDto studentRequestDto) {
        try {
            String response = studentService.updateStudentById(id, studentRequestDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PatchMapping("/updateByMobile/{id}")
    public ResponseEntity<?> updateStudentByPatch(@PathVariable int id, @RequestParam String mobile) {
        try {
            String response = studentService.updateStudentByPatch(id, mobile);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/findByPage")
    public ResponseEntity<?> findStudentBasedOnPage(@RequestParam int pageNo, @RequestParam int pageSize) {
        try {
            List<Student> studentList = studentService.getAllStudentByPage(pageNo, pageSize);
            return ResponseEntity.ok(studentList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<?> findStudentByEmail(@RequestParam String email) {
        try {
            Student student = studentService.getStudentByEmail(email);
            return ResponseEntity.ok(student);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/findByDept")
    public ResponseEntity<?> findStudentByDept(@RequestParam String dept) {
        try {
            List<Student> studentList = studentService.getStudentByDept(dept);
            return ResponseEntity.ok(studentList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/findByEmailAndDept")
    public ResponseEntity<?> findByEmailAndDept(@RequestParam String email, @RequestParam String dept) {
        try {
            Student student = studentService.getStudentByEmailAndDept(email, dept);
            return ResponseEntity.ok(student);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/findByEmailOrDeptAnd")
    public ResponseEntity<?> findByEmailOrDept(@RequestParam String email, @RequestParam String dept) {
        try {
            List<Student> studentList = studentService.getStudentByEmailOrDept(email, dept);
            return ResponseEntity.ok(studentList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
