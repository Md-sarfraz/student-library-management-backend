package com.demo.example.student_library_management.converters;

import com.demo.example.student_library_management.model.Student;
import com.demo.example.student_library_management.requestDto.StudentRequestDto;

public class StudentConverter {
    // TODO: Implement conversion logic from Student entity to DTO/view model

    public static Student convertsStudentRequestDtoToStudent(StudentRequestDto StudentRequestDto){
        Student student=new Student();
        student.setName(StudentRequestDto.getName());
        student.setEmail(StudentRequestDto.getEmail());
        student.setMobile(StudentRequestDto.getMobile());
        student.setDob(StudentRequestDto.getDob());
        student.setGender(StudentRequestDto.getGender());
        student.setDept(StudentRequestDto.getDept());
        return student;
    }
}
