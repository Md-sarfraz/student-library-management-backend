package com.demo.example.student_library_management.controllers;

import com.demo.example.student_library_management.model.Student;
import com.demo.example.student_library_management.requestDto.StudentRequestDto;
import com.demo.example.student_library_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
@GetMapping("/findAll")
public List<Student> findAllStudent(){
        List<Student> students =studentService.getAllStudent();
        return students;
}
@GetMapping("/count")
public String countStudent(){
       String response = studentService.getStudentCount();
       return response;
}
@DeleteMapping("/delete/{id}")
public String deleteStudentById(@PathVariable int id){
     String response = studentService.deleteStudentById(id);
     return response;
}
    @PutMapping("/update/{id}")
    public String updateStudentById(@PathVariable int id, @RequestBody StudentRequestDto studentRequestDto){
        String response=studentService.updateStudentById(id,studentRequestDto);
            return response;
        }
        @PatchMapping("/updateByMobile/{id}")
        public String updateStudentByPatch(@PathVariable int id, @RequestParam String mobile){
        String response=studentService.updateStudentByPatch(id,mobile);
        return response;
        }
    }

