package com.demo.example.student_library_management.controllers;

import com.demo.example.student_library_management.model.Movie;
import com.demo.example.student_library_management.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/movies")
@NoArgsConstructor
@AllArgsConstructor
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity<Movie> addMovie(
            @RequestPart("movie") String movieJson,
            @RequestPart("image") MultipartFile imageFile) {

        try {
            // Convert JSON string to Movie object
            ObjectMapper objectMapper = new ObjectMapper();
            Movie movie = objectMapper.readValue(movieJson, Movie.class);
            System.out.println("Received JSON: " + movie);

            // Save movie with image
            Movie savedMovie = movieService.saveMovie(movie, imageFile);
            return ResponseEntity.ok(savedMovie);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
