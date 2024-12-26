package com.demo.example.student_library_management.service;

import com.demo.example.student_library_management.converters.StudentConverter;
import com.demo.example.student_library_management.model.Card;
import com.demo.example.student_library_management.model.Student;
import com.demo.example.student_library_management.repository.StudentRepository;
import com.demo.example.student_library_management.requestDto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
