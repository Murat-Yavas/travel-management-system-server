package com.devtech.tour_service.service.abstracts;

import com.devtech.tour_service.entity.Tour;

import java.util.List;

public interface TourService {

    Tour getOneTour(Long tourId) throws Exception;

    Tour createOneTour(Tour tour) throws Exception;
    List<Tour> getAllTours();
    Tour getToursByName(String tourName);
    List<Tour> getToursByCost(Integer tourCost);

    List<Tour> getToursByCountry(String country);
    List<Tour> getToursByContinent(String continent);
    void deleteOneTour(Long tourId);
}
