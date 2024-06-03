package com.example.aloha.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aloha.models.Image;
import com.example.aloha.repositories.ImageRepository;
import com.example.aloha.services.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public List<Image> getImageByIdAccommodation(Long idAccommodation) {
        List<Image> images = imageRepository.findAll();
        images.removeIf(image -> !image.getAccommodation().getId().equals(idAccommodation));
        return images;
    }

    @Override
    public void createImage(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void updateImage(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public void deleteImagesByAccommodation(Long idAccommodation) {
        List<Image> images = imageRepository.findAll();
        images.removeIf(image -> !image.getAccommodation().getId().equals(idAccommodation));
        for (Image image : images) {
            imageRepository.deleteById(image.getId());
        }
    }

}
