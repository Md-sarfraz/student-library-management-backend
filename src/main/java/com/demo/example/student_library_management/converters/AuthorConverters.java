package com.demo.example.student_library_management.converters;

import com.demo.example.student_library_management.model.Author;
import com.demo.example.student_library_management.requestDto.AuthorRequestDto;

public class AuthorConverters {
    public static Author convertsAuthorRequestDtoToAuthor(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        author.setEmail(authorRequestDto.getEmail());
        author.setCountry(authorRequestDto.getCountry());
        author.setRating(authorRequestDto.getRating());
        return author;
    }
}