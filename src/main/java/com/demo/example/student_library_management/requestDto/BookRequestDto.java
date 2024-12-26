package com.demo.example.student_library_management.requestDto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class BookRequestDto {
    private String title;
    private int pages;
    private String publisherName;
    private String genre;
    private boolean available;
    private int authorId;
    private int cardId;
}
