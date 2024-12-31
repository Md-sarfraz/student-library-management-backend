package com.demo.example.student_library_management.service;

import com.demo.example.student_library_management.converters.StudentConverter;
import com.demo.example.student_library_management.model.Card;
import com.demo.example.student_library_management.model.Student;
import com.demo.example.student_library_management.repository.StudentRepository;
import com.demo.example.student_library_management.requestDto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public String addStudent(StudentRequestDto studentRequestDto) {
        Student student= StudentConverter.convertsStudentRequestDtoToStudent(studentRequestDto);

        Card card=new Card();
        card.setCardStatus("Active");
        student.setCard(card);
        card.setStudent(student);

        studentRepository.save(student);
        return "saved successfully";
    }

    public Optional<Student> getStudentById(int id){
        Optional<Student> studentOptional=studentRepository.findById(id);
        if(studentOptional.isPresent()){
            return studentOptional;
        }
       else {
           throw new RuntimeException("student with id " + id +" is not found");
        }
    }

    public List<Student> getAllStudent(){
       List<Student> studentList= studentRepository.findAll();
       return studentList;
    }

    public String getStudentCount(){
        long count=studentRepository.count();
        return "the total number of students is " + count;
    }

    public String deleteStudentById(int id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()) {
            studentRepository.deleteById(id);
            return "student with id " + id +" is deleted";
        }
        else {
            throw new RuntimeException("Student with id " + id + " is not found");
        }

    }

    public String updateStudentById(int id,StudentRequestDto studentRequestDto){
      Optional<Student> student=getStudentById(id);
      if(student.isPresent()){
          Student updatedStudent=student.get();
          updatedStudent.setName(studentRequestDto.getName());
          updatedStudent.setEmail(studentRequestDto.getEmail());
          updatedStudent.setMobile(studentRequestDto.getMobile());
          updatedStudent.setDob(studentRequestDto.getDob());
          updatedStudent.setGender(studentRequestDto.getGender());
          updatedStudent.setDept(studentRequestDto.getDept());
          studentRepository.save(updatedStudent);
          return "student with id " + id +" is updated";
      }
      else {
          throw new RuntimeException("student with id " + id +" is not found");
      }

    }
public String updateStudentByPatch(@PathVariable int id, @RequestParam String mobile){
        Optional<Student> student=getStudentById(id);
        if(student.isPresent()){
            Student updatedStudent=student.get();
            updatedStudent.setMobile(mobile);
            studentRepository.save(updatedStudent);
            return"student with id " + id +" mobile no is updated";
        }
        else {
            throw new RuntimeException("student with id " + id +" is not found");
        }
}

                         // pagination
    public List<Student> getAllStudentByPage(int pageNo, int pageSize){
       Page<Student> studentPage=studentRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by("name")));
       List<Student> studentList=studentPage.getContent();
       return studentList;
    }

    public Student getStudentByEmail(String email){
        Student student=studentRepository.findByEmail(email);
        return student;
    }

    public List<Student> getStudentByDept(String dept){
        List<Student> studentList = studentRepository.findByDept(dept);
        return studentList;
    }

    public Student getStudentByEmailAndDept(String email, String dept){
        Student student= studentRepository.findByEmailAndDept(email, dept);
        return student;
    }

    public List<Student> getStudentByEmailOrDept(String email, String dept){
        List<Student>studentList= studentRepository.findByEmailOrDept(email, dept);
        return studentList;
    }
}
