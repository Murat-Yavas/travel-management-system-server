package com.devtech.hotel_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name cannot be empty") @NotBlank @Size(min = 2, max = 40, message = "Name must be 2 to 40 characters")
    private String name;

    @NotEmpty @NotBlank @Size(min = 3, max = 30, message = "Country must be 3 to 30 characters")
    private String country;

    @NotEmpty @NotBlank @Size(min = 4, max = 20, message = "City must be 4 to 20 characters")
    private String city;

    @NotEmpty @NotBlank @Size(min = 12, max = 50, message = "Address must be 12 to 50 characters")
    private String address;

    @NotEmpty @NotBlank
    private String hotelImage;

    private ArrayList<String> contact;

    @NotEmpty @NotBlank
    private String star;

    @NotNull @Min(0)
    private Integer cost;

    private ArrayList<String> amenities;
}


