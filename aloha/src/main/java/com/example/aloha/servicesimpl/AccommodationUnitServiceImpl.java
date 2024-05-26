package com.example.aloha.servicesimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aloha.models.AccommodationUnit;
import com.example.aloha.repositories.AccommodationUnitRepository;
import com.example.aloha.repositories.AccommodationUnitServiceRepository;
import com.example.aloha.services.AccommodationUnitService;

@Service
public class AccommodationUnitServiceImpl implements AccommodationUnitService {

    @Autowired
    private AccommodationUnitRepository accommodationUnitRepository;

    @Autowired
    private AccommodationUnitServiceRepository accommodationUnitServiceRepository;

    @Override
    public List<AccommodationUnit> getAccommodationUnits() {
        return accommodationUnitRepository.getAll();
    }

    @Override
    public AccommodationUnit getAccommodationUnitById(Long id) {
        return accommodationUnitRepository.findById(id).orElse(null);
    }

    @Override
    public void createAccommodationUnit(AccommodationUnit accommodationUnit) {
        accommodationUnitRepository.save(accommodationUnit);
    }

    @Override
    public void deleteAccommodationUnitById(Long id) {
        accommodationUnitRepository.deleteById(id);
    }

    @Override
    public void updateAccommodationUnit(AccommodationUnit accommodationUnit) {
        accommodationUnitRepository.save(accommodationUnit);
    }

    @Override
    public List<AccommodationUnit> getAccommodationUnitsByAccommodationLocation(String location) {
        return accommodationUnitRepository.findAll().stream()
                .filter(accommodationUnit -> accommodationUnit.getAccommodation().getLocation().equals(location))
                .toList();
    }

    @Override
    public List<AccommodationUnit> getAccommodationUnitsByCategoryHotel() {
        return accommodationUnitRepository.findAll().stream()
                .filter(accommodationUnit -> accommodationUnit.getCategory().getName().equals("hotel"))
                .toList();
    }

    @Override
    public List<AccommodationUnit> getAccommodationUnitsByCategoryBungalow() {
        return accommodationUnitRepository.findAll().stream()
                .filter(accommodationUnit -> accommodationUnit.getCategory().getName().equals("bungalow"))
                .toList();
    }

    @Override
    public List<AccommodationUnit> getAccommodationUnitsByCategoryHostel() {
        return accommodationUnitRepository.findAll().stream()
                .filter(accommodationUnit -> accommodationUnit.getCategory().getName().equals("hostel"))
                .toList();
    }

    @Override
    public List<AccommodationUnit> getAccommodationUnitsByCategoryHouse() {
        return accommodationUnitRepository.findAll().stream()
                .filter(accommodationUnit -> accommodationUnit.getCategory().getName().equals("house"))
                .toList();
    }

    @Override
    public List<AccommodationUnit> getAccommodationUnitsByCategories(Boolean[] categories) {
        List<List<AccommodationUnit>> listaPrincipal = new ArrayList<>();
        List<AccommodationUnit> accommodationUnits = accommodationUnitRepository.findAll();
        List<AccommodationUnit> lista = new ArrayList<>();

        for (int i = 0; i < categories.length; i++) {
            if (categories[i]) {
                switch (i) {
                    case 0:
                        lista = accommodationUnits.stream()
                                .filter(accommodationUnit -> accommodationUnit.getCategory().getName().equals("house"))
                                .toList();
                        break;
                    case 1:
                        lista = accommodationUnits.stream()
                                .filter(accommodationUnit -> accommodationUnit.getCategory().getName()
                                        .equals("hotel"))
                                .toList();
                        break;
                    case 2:
                        accommodationUnits = accommodationUnits.stream()
                                .filter(accommodationUnit -> accommodationUnit.getCategory().getName().equals("hostel"))
                                .toList();
                        listaPrincipal.add(accommodationUnits);
                        break;

                    case 3:
                        accommodationUnits = accommodationUnits.stream()
                                .filter(accommodationUnit -> accommodationUnit.getCategory().getName()
                                        .equals("bungalow"))
                                .toList();

                        break;
                    default:
                }
                listaPrincipal.add(lista);
            }
        }

        return listaPrincipal.stream().flatMap(List::stream).toList();

    }

    @Override
    public List<AccommodationUnit> getAccommodationUnitsByService(Boolean[] service) {
        List<List<com.example.aloha.models.AccommodationUnitService>> listaPrincipal = new ArrayList<>();
        List<com.example.aloha.models.AccommodationUnitService> ac = accommodationUnitServiceRepository.findAll();

        List<com.example.aloha.models.AccommodationUnitService> listAc = new ArrayList<>();
        List<AccommodationUnit> accommodationUnits = new ArrayList<>();

        for (int i = 0; i < service.length; i++) {
            if (service[i]) {
                switch (i) {
                    case 0:
                        listAc = ac.stream().filter(acc -> acc.getService().getName().equals("Piscina")).toList();
                        break;

                    case 1:
                        listAc = ac.stream().filter(acc -> acc.getService().getName().equals("Admite mascotas"))
                                .toList();
                        break;

                    case 2:
                        listAc = ac.stream().filter(acc -> acc.getService().getName().equals("Wifi")).toList();
                        break;

                    case 3:
                        listAc = ac.stream().filter(acc -> acc.getService().getName().equals("Parking")).toList();
                        break;

                    default:
                }
                listaPrincipal.add(listAc);
            }
        }

        for (int i = 0; i < listaPrincipal.size(); i++) {
            for (int j = 0; j < listaPrincipal.get(i).size(); j++) {
                accommodationUnits.add(listaPrincipal.get(i).get(j).getAccommodationUnit());
            }
        }

        return accommodationUnits;

    }

}
