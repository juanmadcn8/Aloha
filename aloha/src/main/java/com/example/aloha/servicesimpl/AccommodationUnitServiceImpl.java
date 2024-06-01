package com.example.aloha.servicesimpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import com.example.aloha.models.AccommodationUnit;
import com.example.aloha.models.Booking;
import com.example.aloha.repositories.AccommodationUnitRepository;
import com.example.aloha.repositories.AccommodationUnitServiceRepository;
import com.example.aloha.repositories.BookingRepository;
import com.example.aloha.services.AccommodationUnitService;

@Service
public class AccommodationUnitServiceImpl implements AccommodationUnitService {

    @Autowired
    private AccommodationUnitRepository accommodationUnitRepository;

    @Autowired
    private AccommodationUnitServiceRepository accommodationUnitServiceRepository;

    @Autowired
    private BookingRepository bookingRepository;

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

    @Override
    public List<AccommodationUnit> getAccommodationUnitsByMaxPrice(Double maxPrice) {
        return accommodationUnitRepository.getAccommodationUnitsByMaxPrice(maxPrice);
    }

    @Override
    public List<AccommodationUnit> getAccommodationUnitsByLocationMaxPriceServicesAndCategories(String location,
            Double maxPrice, Boolean[] services, Boolean[] categories, Date checkIn, Date checkOut, Integer capacity) {

        List<List<com.example.aloha.models.AccommodationUnitService>> listaPrincipal = new ArrayList<>();

        List<AccommodationUnit> accommodationUnits = new ArrayList<>();

        List<com.example.aloha.models.AccommodationUnitService> ac = new ArrayList<>();

        if (location != null && !location.equals("") && !location.equals("null")) {
            ac = accommodationUnitServiceRepository.findAll()
                    .stream()
                    .filter(acc -> acc.getAccommodationUnit().getAccommodation().getLocation().equals(location))
                    .toList();
        } else {
            ac = accommodationUnitServiceRepository.findAll();
        }

        List<Boolean> serviceList = new ArrayList<>();
        serviceList = Arrays.asList(services);

        List<Boolean> categoryList = new ArrayList<>();
        categoryList = Arrays.asList(categories);

        ac = ac.stream().filter(acc -> acc.getAccommodationUnit().getPrice() <= maxPrice).toList();

        List<com.example.aloha.models.AccommodationUnitService> acCopia = new ArrayList<>(ac);

        if (serviceList.contains(true)) {
            for (int i = 0; i < services.length; i++) {
                if (services[i]) {
                    switch (i) {
                        case 0:
                            acCopia = ac.stream().filter(acc -> acc.getService().getName().equals("Piscina"))
                                    .toList();
                            break;

                        case 1:
                            acCopia = ac.stream().filter(acc -> acc.getService().getName().equals("Admite mascotas"))
                                    .toList();
                            break;

                        case 2:
                            acCopia = ac.stream().filter(acc -> acc.getService().getName().equals("Wifi")).toList();
                            break;

                        case 3:
                            acCopia = ac.stream().filter(acc -> acc.getService().getName().equals("Parking")).toList();
                            break;

                        default:
                    }

                    if (categoryList.contains(true)) {
                        for (int j = 0; j < categories.length; j++) {
                            if (categories[j]) {
                                switch (j) {
                                    case 0:
                                        acCopia = acCopia.stream()
                                                .filter(acc -> acc.getAccommodationUnit().getCategory()
                                                        .getName().equals("house"))
                                                .toList();
                                        break;

                                    case 1:
                                        acCopia = acCopia.stream()
                                                .filter(acc -> acc.getAccommodationUnit().getCategory()
                                                        .getName().equals("hotel"))
                                                .toList();
                                        break;

                                    case 2:
                                        acCopia = acCopia.stream()
                                                .filter(acc -> acc.getAccommodationUnit().getCategory()
                                                        .getName().equals("hostel"))
                                                .toList();
                                        break;

                                    case 3:
                                        acCopia = acCopia.stream()
                                                .filter(acc -> acc.getAccommodationUnit().getCategory()
                                                        .getName().equals("bungalow"))
                                                .toList();
                                        break;

                                    default:
                                }
                            }

                        }
                    }
                    listaPrincipal.add(acCopia);
                }
            }

        } else if (categoryList.contains(true)) {
            for (int i = 0; i < categories.length; i++) {
                if (categories[i]) {
                    switch (i) {
                        case 0:
                            acCopia = ac.stream().filter(acc -> acc.getAccommodationUnit().getCategory().getName()
                                    .equals("house")).toList();
                            break;

                        case 1:
                            acCopia = ac.stream().filter(acc -> acc.getAccommodationUnit().getCategory().getName()
                                    .equals("hotel")).toList();
                            break;

                        case 2:
                            acCopia = ac.stream().filter(acc -> acc.getAccommodationUnit().getCategory().getName()
                                    .equals("hostel")).toList();
                            break;

                        case 3:
                            acCopia = ac.stream().filter(acc -> acc.getAccommodationUnit().getCategory().getName()
                                    .equals("bungalow")).toList();
                            break;

                        default:
                    }
                    listaPrincipal.add(acCopia);
                }
            }
        } else {
            listaPrincipal.add(ac);
        }

        for (int i = 0; i < listaPrincipal.size(); i++) {
            for (int j = 0; j < listaPrincipal.get(i).size(); j++) {
                accommodationUnits.add(listaPrincipal.get(i).get(j).getAccommodationUnit());
            }
        }

        System.out.println(accommodationUnits);

        List<Booking> bookings = new ArrayList<>();

        for (int i = 0; i < accommodationUnits.size(); i++) {
            bookings = bookingRepository.findByAccommodationUnitId(accommodationUnits.get(i).getId());
            for (int j = 0; j < bookings.size(); j++) {
                if (!isAvailable(checkIn, checkOut, bookings.get(j).getCheckIn(), bookings.get(j).getCheckOut())) {
                    accommodationUnits.remove(accommodationUnits.get(i));
                }
            }
        }

        accommodationUnits = accommodationUnits.stream()
                .filter(accommodationUnit -> accommodationUnit.getCapacity() >= capacity).toList();

        return accommodationUnits;

    }

    @Override
    public void deleteAccommodationUnitByIdAccommodation(Long id) {
        accommodationUnitRepository.deleteAccommodationUnitByIdAccommodation(id);
    }

    private boolean isAvailable(Date checkIn, Date checkOut, Date newCheckIn, Date newCheckOut) {
        return (newCheckIn.before(checkIn) && newCheckOut.before(checkIn))
                || (newCheckIn.after(checkOut) && newCheckOut.after(checkOut));

    }

}
