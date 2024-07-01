package com.devtech.hotel_service.repository;

import com.devtech.hotel_service.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByCity(String city);

    Hotel findByName(String name);

    List<Hotel> findByCountry(String country);
}
