package com.devtech.user_microservice.entity;

import com.devtech.user_microservice.external.HotelDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotEmpty @NotBlank @Size(min = 2, max = 20,message = "Name must contain at least 2 characters")
    private String firstname;

    //@NotEmpty @NotBlank @Size(min = 2, max = 20,message = "Last name must contain at least 2 characters")
    private String lastname;

//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,15}$",
//            message = "Password must be 6 to 15 characters and must have at least one alphabet and one number")
    //@NotEmpty @NotBlank
    private String password;

    //@NotEmpty @NotBlank
    private String email;


    //@NotEmpty @NotBlank @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
    private String phoneNumber;


    private ArrayList<UserHotel> userHotels;

    private ArrayList<UserTour> userTours;
}
