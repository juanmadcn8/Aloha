package com.example.aloha.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.aloha.models.ServiceModel;
import com.example.aloha.repositories.ServiceModelRepository;
import com.example.aloha.services.ServiceModelService;

@Service
public class ServiceServiceModelImpl implements ServiceModelService {

    private ServiceModelRepository serviceRepository;

    @Override
    public List<ServiceModel> getServices() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<ServiceModel> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void createService(ServiceModel service) {
        serviceRepository.save(service);
    }

    @Override
    public void deleteServiceById(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public void updateService(ServiceModel service) {
        serviceRepository.save(service);
    }

}
