package com.devtech.tour_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty @NotBlank @Size(min = 2, max = 30, message = "Country must be 2 to 30 characters long")
    private String country;

    @NotEmpty @NotBlank @Size(min = 2, max = 15, message = "Continent must be 2 to 15 characters long")
    private String continent;

    @NotEmpty @NotBlank @Size(min = 5, max = 30, message = "Name must be 5 to 30 characters long")
    private String name;

    private ArrayList<String> routes;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private ArrayList<Date> tourStartDate;

    @NotNull @Min(4)
    private Integer days;

    private ArrayList<String> addOns;

    @NotNull @Min(10) @Max(51)
    private Integer groupSize;

    @NotEmpty @NotBlank
    private String tourImage;

    private ArrayList<Integer> ageRange;

    @NotNull @Min(0)
    private Integer cost;

    @NotEmpty @NotBlank @Size(min = 3, max = 10, message = "OperatedIn must be 3 to 10 characters long")
    private String operatedIn;

    @NotEmpty @NotBlank @Size(min = 5, message = "Payment details must be at least 5 characters long")
    private String paymentDetails;
}
