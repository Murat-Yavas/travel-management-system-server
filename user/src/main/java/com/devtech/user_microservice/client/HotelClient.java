package com.devtech.user_microservice.client;

import com.devtech.user_microservice.external.HotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hotel-service", url = "http://localhost:8082")
public interface HotelClient {

    @GetMapping("/hotels/id")
    public HotelDto getHotel(@RequestParam Long id);
}
