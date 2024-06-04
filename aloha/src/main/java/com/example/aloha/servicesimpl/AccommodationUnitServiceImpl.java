package com.example.aloha.servicesimpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        List<AccommodationUnit> accommodationUnits = new ArrayList<>();
        List<com.example.aloha.models.AccommodationUnitService> ac = new ArrayList<>();

        if (location != null && !location.isEmpty() && !location.equals("null")) {
            ac = accommodationUnitServiceRepository.findAll()
                    .stream()
                    .filter(acc -> acc.getAccommodationUnit().getAccommodation().getLocation().equals(location))
                    .toList();
        } else {
            ac = accommodationUnitServiceRepository.findAll();
        }

        ac = ac.stream().filter(acc -> acc.getAccommodationUnit().getPrice() <= maxPrice).toList();

        List<String> requiredServices = new ArrayList<>();
        if (services[0])
            requiredServices.add("Piscina");
        if (services[1])
            requiredServices.add("Admite mascotas");
        if (services[2])
            requiredServices.add("Wifi");
        if (services[3])
            requiredServices.add("Parking");

        if (!requiredServices.isEmpty()) {
            ac = ac.stream()
                    .collect(Collectors.groupingBy(acc -> acc.getAccommodationUnit()))
                    .entrySet()
                    .stream()
                    .filter(entry -> {
                        List<String> unitServices = entry.getValue()
                                .stream()
                                .map(acc -> acc.getService().getName())
                                .distinct()
                                .toList();
                        return unitServices.containsAll(requiredServices);
                    })
                    .flatMap(entry -> entry.getValue().stream())
                    .toList();
        }

        List<String> requiredCategories = new ArrayList<>();
        if (categories[0])
            requiredCategories.add("house");
        if (categories[1])
            requiredCategories.add("hotel");
        if (categories[2])
            requiredCategories.add("hostel");
        if (categories[3])
            requiredCategories.add("bungalow");

        if (!requiredCategories.isEmpty()) {
            ac = ac.stream()
                    .filter(acc -> requiredCategories.contains(acc.getAccommodationUnit().getCategory().getName()))
                    .toList();
        }

        accommodationUnits = ac.stream()
                .map(com.example.aloha.models.AccommodationUnitService::getAccommodationUnit)
                .distinct()
                .toList();

        accommodationUnits = accommodationUnits.stream()
                .filter(accommodationUnit -> {
                    List<Booking> bookings1 = bookingRepository.findByAccommodationUnitId(accommodationUnit.getId());
                    for (Booking booking : bookings1) {
                        if (!isAvailable(checkIn, checkOut, booking.getCheckIn(), booking.getCheckOut())) {
                            return false;
                        }
                    }
                    return true;
                }).toList();

        accommodationUnits = accommodationUnits.stream()
                .filter(accommodationUnit -> accommodationUnit.getCapacity() >= capacity)
                .toList();

        return accommodationUnits;
    }

    @Override
    public void deleteAccommodationUnitByIdAccommodation(Long id) {
        accommodationUnitRepository.deleteAccommodationUnitByIdAccommodation(id);
    }

    private boolean isAvailable(Date newCheckIn, Date newCheckOut, Date checkIn, Date checkOut) {
        return (newCheckIn.before(checkIn) && newCheckOut.before(checkIn))
                || (newCheckIn.after(checkOut) && newCheckOut.after(checkOut))
                || (newCheckIn.equals(checkOut) && newCheckOut.after(checkOut));

    }

}
