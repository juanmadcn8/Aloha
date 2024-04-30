package com.example.aloha.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aloha.models.Lessor;
import com.example.aloha.repositories.LessorRepository;
import com.example.aloha.services.LessorService;

@Service
public class LessorServiceImpl implements LessorService {

    @Autowired
    private LessorRepository lessorRepository;

    @Override
    public List<Lessor> getLessors() {
        return lessorRepository.findAll();
    }

    @Override
    public Optional<Lessor> getLessorById(Long id) {
        return lessorRepository.findById(id);
    }

    @Override
    public void createLessor(Lessor lessor) {
        lessorRepository.save(lessor);
    }

    @Override
    public void deleteLessorById(Long id) {
        lessorRepository.deleteById(id);
    }

    @Override
    public void updateLessor(Lessor lessor) {
        lessorRepository.save(lessor);
    }

}
