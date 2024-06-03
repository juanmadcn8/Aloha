package com.example.aloha.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aloha.models.Image;
import com.example.aloha.services.ImageService;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping()
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/accommodation/{idAccommodation}")
    public List<Image> getImageByIdAccommodation(@PathVariable Long idAccommodation) {
        return imageService.getImageByIdAccommodation(idAccommodation);
    }

    @PostMapping("/create")
    public void createImage(@RequestBody Image image) {
        imageService.createImage(image);
    }

    @PutMapping("/update")
    public void updateImage(@RequestBody Image image) {
        imageService.updateImage(image);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
    }

}
