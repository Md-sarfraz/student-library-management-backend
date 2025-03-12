package com.demo.example.student_library_management.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.demo.example.student_library_management.model.Movie;
import com.demo.example.student_library_management.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private Cloudinary cloudinary;

    public Movie saveMovie(Movie movie, MultipartFile imageFile) throws IOException {
        // Upload image to Cloudinary
        Map uploadResult = cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());

        // Get Cloudinary image URL
        String imageUrl = uploadResult.get("secure_url").toString();
        movie.setPostUrl(imageUrl);
        // Save movie to the database
        return movieRepository.save(movie);
    }

}
