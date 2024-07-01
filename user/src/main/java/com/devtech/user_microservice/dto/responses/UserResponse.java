package com.devtech.user_microservice.dto.responses;

import com.devtech.user_microservice.entity.User;
import com.devtech.user_microservice.entity.UserHotel;
import com.devtech.user_microservice.entity.UserTour;
import com.devtech.user_microservice.external.HotelDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserResponse {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private ArrayList<UserHotel> userHotels;
    private ArrayList<UserTour> userTours;

    public UserResponse(User user) {
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.userHotels = user.getUserHotels();
        this.userTours = user.getUserTours();
    }
}
