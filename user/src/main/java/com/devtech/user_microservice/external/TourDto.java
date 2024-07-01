package com.devtech.user_microservice.external;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourDto {
    private Long id;
    private String country;
    private String continent;
    private String name;
    private ArrayList<String> routes;
    private ArrayList<Date> tourStartDate;
    private Integer days;
    private ArrayList<String> addOns;
    private Integer groupSize;
    private String tourImage;
    private ArrayList<Integer> ageRange;
    private Integer cost;
    private String operatedIn;
    private String paymentDetails;
}
