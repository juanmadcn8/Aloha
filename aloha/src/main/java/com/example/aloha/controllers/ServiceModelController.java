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

import com.example.aloha.models.ServiceModel;
import com.example.aloha.services.ServiceModelService;

@RestController
@RequestMapping("/api/service")
public class ServiceModelController {

    @Autowired
    private ServiceModelService serviceModelService;

    @GetMapping()
    public List<ServiceModel> getServices() {
        return serviceModelService.getServices();
    }

    @GetMapping("/{id}")
    public Optional<ServiceModel> getServiceById(@PathVariable Long id) {
        return serviceModelService.getServiceById(id);
    }

    @GetMapping("/accommodation-unit/{id}")
    public List<ServiceModel> getServicesByAccommodationUnitId(@PathVariable Long id) {
        return serviceModelService.getServicesByAccommodationUnitId(id);
    }

    @PostMapping("/create")
    public void createService(@RequestBody ServiceModel service) {
        serviceModelService.createService(service);
    }

    @PutMapping("/update")
    public void updateService(@RequestBody ServiceModel service) {
        serviceModelService.updateService(service);
    }

    @DeleteMapping("/delete")
    public void deleteServiceById(@RequestBody ServiceModel service) {
        serviceModelService.deleteServiceById(service.getId());
    }

}
