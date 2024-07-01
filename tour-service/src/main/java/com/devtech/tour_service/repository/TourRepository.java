package com.devtech.tour_service.repository;

import com.devtech.tour_service.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {
    Tour findByName(String name);

    List<Tour> findByCost(Integer cost);

    List<Tour> findByCountry(String country);

    List<Tour> findByContinent(String continent);
}
