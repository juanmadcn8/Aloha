package com.example.aloha.servicesimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aloha.models.AccommodationUnitService;
import com.example.aloha.models.ServiceModel;
import com.example.aloha.repositories.AccommodationUnitServiceRepository;
import com.example.aloha.repositories.ServiceModelRepository;
import com.example.aloha.services.ServiceModelService;

@Service
public class ServiceServiceModelImpl implements ServiceModelService {

    @Autowired
    private ServiceModelRepository serviceRepository;

    @Autowired
    private AccommodationUnitServiceRepository accommodationUnitServiceRepository;

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

    @Override
    public List<ServiceModel> getServicesByAccommodationUnitId(Long id) {
        List<AccommodationUnitService> ac = accommodationUnitServiceRepository.findByAccommodationUnitId(id);
        List<ServiceModel> services = new ArrayList<>();

        for (int i = 0; i < ac.size(); i++) {
            services.add(ac.get(i).getService());
        }

        return services;
    }

}
