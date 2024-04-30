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
import org.springframework.web.bind.annotation.RestController;

import com.example.aloha.models.Admin;
import com.example.aloha.services.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping()
    public List<Admin> getAdmins() {
        return adminService.getAdmins();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PostMapping("/create")
    public void createAdmin(@RequestBody Admin admin) {
        adminService.createAdmin(admin);
    }

    @PutMapping("/update")
    public void updateAdmin(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
    }

    @DeleteMapping("/delete")
    public void deleteAdmin(@RequestBody Admin admin) {
        adminService.deleteAdminById(admin.getId());
    }

}
