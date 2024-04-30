package com.example.aloha.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aloha.models.Admin;
import com.example.aloha.repositories.AdminRepository;
import com.example.aloha.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public void createAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void deleteAdminById(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminRepository.save(admin);
    }

}
