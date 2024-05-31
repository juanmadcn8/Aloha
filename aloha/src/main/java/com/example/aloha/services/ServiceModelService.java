package com.example.aloha.services;

import java.util.List;
import java.util.Optional;

import com.example.aloha.models.ServiceModel;

public interface ServiceModelService {

    public List<ServiceModel> getServices();

    public Optional<ServiceModel> getServiceById(Long id);

    public List<ServiceModel> getServicesByAccommodationUnitId(Long id);

    public void createService(ServiceModel service);

    public void deleteServiceById(Long id);

    public void updateService(ServiceModel service);
}
