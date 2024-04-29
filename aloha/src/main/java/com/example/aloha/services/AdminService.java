package com.example.aloha.services;

import java.util.List;

import com.example.aloha.models.Admin;

public interface AdminService {

    public List<Admin> getAdmins();

    public void createAdmin(Admin admin);

    public void deleteAdmin();

    public void updateAdmin();
}
