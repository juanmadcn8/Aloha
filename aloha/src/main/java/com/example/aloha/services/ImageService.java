package com.example.aloha.services;

import java.util.List;

import com.example.aloha.models.Image;

public interface ImageService {

    public List<Image> getAllImages();

    public List<Image> getImageByIdAccommodation(Long idAccommodation);

    public void createImage(Image image);

    public void updateImage(Image image);

    public void deleteImage(Long id);

    public void deleteImagesByAccommodation(Long idAccommodation);
}
