package com.devtech.tour_service.service.concretes;

import com.devtech.tour_service.entity.Tour;
import com.devtech.tour_service.repository.TourRepository;
import com.devtech.tour_service.service.abstracts.TourService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TourManager implements TourService {

    private TourRepository tourRepository;

    @Override
    public Tour getOneTour(Long tourId) throws Exception{
        return tourRepository.findById(tourId)
                .orElseThrow(() -> new Exception("Tour with id: " + tourId + " not found"));
    }

    @Override
    public Tour createOneTour(Tour tour) throws Exception {
        Tour foundTour = tourRepository.findByName(tour.getName());
        if(foundTour == null) return tourRepository.save(tour);
        else {
            if(foundTour.getName().equals(tour.getName()))
                throw new Exception("Tour with name: "+ tour.getName() + " already exists");
            else return tourRepository.save(tour);
        }
    }

    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public Tour getToursByName(String tourName) {
        return null;
    }

//    @Override
//    public List<Tour> getToursByName(String name) {
//        return tourRepository.findByName(name);
//    }

    @Override
    public List<Tour> getToursByCost(Integer cost) {
        return tourRepository.findByCost(cost);
    }

    @Override
    public List<Tour> getToursByCountry(String country) {
        return tourRepository.findByCountry(country);
    }

    @Override
    public List<Tour> getToursByContinent(String continent) {
        return tourRepository.findByContinent(continent);
    }

    @Override
    public void deleteOneTour(Long tourId) {
        tourRepository.deleteById(tourId);
    }
}
