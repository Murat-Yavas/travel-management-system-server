package com.devtech.hotel_service.service.concretes;

import com.devtech.hotel_service.entity.Hotel;
import com.devtech.hotel_service.repository.HotelRepository;
import com.devtech.hotel_service.service.abstracts.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HotelManager implements HotelService {

    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel createOneHotel(Hotel hotel) throws Exception{
        Hotel foundHotel = hotelRepository.findByName(hotel.getName());

        if(foundHotel == null) return hotelRepository.save(hotel);
        else {
            if(foundHotel.getName().equals(hotel.getName()))
            throw new Exception("Hotel with name: " + hotel.getName() + " already exists");
        else return hotelRepository.save(hotel);
        }
    }

    @Override
    public List<Hotel> getHotelsByTour(String tourName) {
        return null;
    }

    @Override
    public List<Hotel> getHotelsByCity(String city) {
        return hotelRepository.findByCity(city);
    }

    @Override
    public List<Hotel> getHotelsByCountry(String country) {
        return hotelRepository.findByCountry(country);
    }

    @Override
    public Hotel getOneHotelByName(String name) {
        return hotelRepository.findByName(name);
    }

    @Override
    public Hotel getOneHotelById(Long hotelId) throws Exception{
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new Exception("Hotel with id: " + hotelId +" not found"));
    }

}
