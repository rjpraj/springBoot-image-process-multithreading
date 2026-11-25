package com.example.MultithreadingUsingExecutorService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ImageProcessingService {
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public void processImage(List<String> imagePaths){
        for(String path:imagePaths){
//            compressImage(path);
            executorService.submit(()->compressImage(path));
        }

    }

    private void compressImage(String imagePath){
        System.out.println("process this "+imagePath+ "with Thread "+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
            System.out.println("Image processsing is completed "+imagePath);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
