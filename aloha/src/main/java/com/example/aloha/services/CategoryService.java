package com.example.aloha.services;

import java.util.List;
import java.util.Optional;

import com.example.aloha.models.Category;

public interface CategoryService {

    public void createCategory(Category category);

    public void updateCategory(Category category);

    public void deleteCategoryById(Long id);

    public List<Category> getCategories();

    public Optional<Category> getCategoryById(Long id);
}
