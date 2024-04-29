package com.example.aloha.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aloha.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
