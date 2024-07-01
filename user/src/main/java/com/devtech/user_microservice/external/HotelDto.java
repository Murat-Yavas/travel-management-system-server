package com.devtech.user_microservice.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {

    private Long id;
    private String name;
    private String country;
    private String city;
    private String address;
    private String hotelImage;
    private ArrayList<String> contact;
    private String star;
    private Integer cost;
    private ArrayList<String> amenities;
}
