package com.demo.example.student_library_management.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dlemwjpue");
        config.put("api_key", "523483865836267");
        config.put("api_secret", "VMbeOCWCu7MRPbU_ShJzEhxYg1k");
        return new Cloudinary(config);
    }
}
