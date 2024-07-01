package com.devtech.tour_service.controller;

import com.devtech.tour_service.entity.Tour;
import com.devtech.tour_service.service.abstracts.TourService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tours")
@AllArgsConstructor
@CrossOrigin("*")
public class TourController {

    private TourService tourService;

    @GetMapping("/{id}")
    public ResponseEntity<Tour> receiveOneTour(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(tourService.getOneTour(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tour> addOneTour(@RequestBody Tour tour) throws Exception {
        return new ResponseEntity<>(tourService.createOneTour(tour), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tour>> receiveAllTours() {
        return new ResponseEntity<>(tourService.getAllTours(), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<Tour> receiveToursByName(@RequestParam String tourName) {
        return new ResponseEntity<>(tourService.getToursByName(tourName), HttpStatus.OK);
    }

    @GetMapping("/cost")
    public ResponseEntity<List<Tour>> receiveToursByCost(@RequestParam Integer tourCost) {
        return new ResponseEntity<>(tourService.getToursByCost(tourCost), HttpStatus.OK);
    }

    @GetMapping("/country")
    public ResponseEntity<List<Tour>> receiveToursByCountry(@RequestParam String countryName) {
        return new ResponseEntity<>(tourService.getToursByCountry(countryName), HttpStatus.OK);
    }

    @GetMapping("/continent")
    public ResponseEntity<List<Tour>> receiveToursByContinent(@RequestParam String continentName) {
        return new ResponseEntity<>(tourService.getToursByContinent(continentName), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOneTour(@PathVariable Long id) {
        tourService.deleteOneTour(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
