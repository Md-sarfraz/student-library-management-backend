package com.demo.example.student_library_management.requestDto;

import lombok.Data;

@Data
public class StudentRequestDto {
    private String name;
    private String email;
    private String mobile;
    private String dob;
    private String gender;
    private String dept;
}
