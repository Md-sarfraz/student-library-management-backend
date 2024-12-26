package com.demo.example.student_library_management.converters;

import com.demo.example.student_library_management.model.Book;
import com.demo.example.student_library_management.requestDto.BookRequestDto;

public class BookConverters {
    public static Book convertsBookRequestDtoBook(BookRequestDto bookRequestDto){
        Book book=new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setPages(bookRequestDto.getPages());
        book.setPublisherName(bookRequestDto.getPublisherName());
        book.setGenre(bookRequestDto.getGenre());
        book.setAvailable(bookRequestDto.isAvailable());
        return book;
    }
}
