package com.demo.example.student_library_management.requestDto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AuthorRequestDto {
    private String name;
    private String email;
    private String country;
    private String rating;
}
