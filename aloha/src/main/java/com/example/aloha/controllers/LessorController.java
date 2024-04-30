package com.example.aloha.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.aloha.models.Lessor;
import com.example.aloha.services.LessorService;

@RestController
@RequestMapping("/api/lessor")
public class LessorController {

    @Autowired
    private LessorService lessorService;

    @GetMapping()
    public List<Lessor> getLessors() {
        return lessorService.getLessors();
    }

    @GetMapping("/{id}")
    public Optional<Lessor> getLessorById(@PathVariable Long id) {
        return lessorService.getLessorById(id);
    }

    @PostMapping("/create")
    public void createLessor(@RequestBody Lessor lessor) {
        lessorService.createLessor(lessor);
    }

    @PutMapping("/update")
    public void updateLessor(@RequestBody Lessor lessor) {
        lessorService.updateLessor(lessor);
    }

    @DeleteMapping("/delete")
    public void deleteLessor(@RequestBody Lessor lessor) {
        lessorService.deleteLessorById(lessor.getId());
    }

}
