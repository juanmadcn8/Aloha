package com.example.aloha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.Lessor;

@Repository
public interface LessorRepository extends JpaRepository<Lessor, Long> {

}
