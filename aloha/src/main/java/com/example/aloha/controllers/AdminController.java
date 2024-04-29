package com.example.aloha.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/create")
    public void createAdmin(@RequestBody Admin admin) {
        adminService.createAdmin(admin);
    }

}
