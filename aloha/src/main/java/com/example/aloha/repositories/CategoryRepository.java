package com.example.aloha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
