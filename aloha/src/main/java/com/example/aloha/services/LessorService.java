package com.example.aloha.services;

import java.util.List;
import java.util.Optional;

import com.example.aloha.models.Lessor;

public interface LessorService {

    public List<Lessor> getLessors();

    public Optional<Lessor> getLessorById(Long id);

    public void createLessor(Lessor lessor);

    public void deleteLessorById(Long id);

    public void updateLessor(Lessor lessor);
}
