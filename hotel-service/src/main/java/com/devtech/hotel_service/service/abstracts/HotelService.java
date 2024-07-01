package com.devtech.hotel_service.service.abstracts;

import com.devtech.hotel_service.entity.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getAllHotels();

    Hotel createOneHotel(Hotel hotel) throws Exception;
    List<Hotel> getHotelsByTour(String tourName);
    List<Hotel> getHotelsByCity(String city);

    List<Hotel> getHotelsByCountry(String country);
    Hotel getOneHotelByName(String hotelName);

    Hotel getOneHotelById(Long hotelId) throws Exception;
}
