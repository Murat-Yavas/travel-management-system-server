package com.devtech.hotel_service.controller;

import com.devtech.hotel_service.entity.Hotel;
import com.devtech.hotel_service.service.abstracts.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@AllArgsConstructor
@CrossOrigin("*")
public class HotelController {

    private HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> receiveAllHotels() {
        return new ResponseEntity<>(hotelService.getAllHotels(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hotel> addOneHotel(@RequestBody Hotel hotel) throws Exception{
        return new ResponseEntity<>(hotelService.createOneHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping("/city")
    public ResponseEntity<List<Hotel>> receiveHotelsByCity(@RequestParam String cityName) {
        return new ResponseEntity<>(hotelService.getHotelsByCity(cityName), HttpStatus.OK);
    }

    @GetMapping("/country")
    public ResponseEntity<List<Hotel>> receiveHotelsByCountry(@RequestParam String countryName) {
        return new ResponseEntity<>(hotelService.getHotelsByCountry(countryName), HttpStatus.OK);
    }

    @GetMapping("/{hotelName}")
    public ResponseEntity<Hotel> receiveOneHotelByName(@PathVariable String hotelName) {
        return new ResponseEntity<>(hotelService.getOneHotelByName(hotelName), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Hotel> receiveOneHotelById(@RequestParam Long id) throws Exception{
        return new ResponseEntity<>(hotelService.getOneHotelById(id), HttpStatus.OK);
    }
}
