package com.devtech.user_microservice.client;

import com.devtech.user_microservice.external.TourDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "tour-service", url = "http://localhost:8083" )
public interface TourClient {

    @GetMapping("/tours/{id}")
    public TourDto getTour(@PathVariable Long id);
}
