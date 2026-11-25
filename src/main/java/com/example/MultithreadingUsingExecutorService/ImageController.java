package com.example.MultithreadingUsingExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageProcessingService imageProcessingService;

    @PostMapping("/process")
    public String imageProcessor(@RequestBody List<String> imagePaths){
        imageProcessingService.processImage(imagePaths);
        return "Image processing started";
    }
}
