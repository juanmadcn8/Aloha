package com.example.aloha.services;

import java.util.List;
import java.util.Optional;

import com.example.aloha.models.Admin;

public interface AdminService {

    public List<Admin> getAdmins();

    public Optional<Admin> getAdminById(Long id);

    public Optional<Admin> getAdminByEmail(String email);

    public void createAdmin(Admin admin);

    public void deleteAdminById(Long id);

    public void updateAdmin(Admin admin);
}
