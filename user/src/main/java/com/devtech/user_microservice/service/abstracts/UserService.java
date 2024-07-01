package com.devtech.user_microservice.service.abstracts;

import com.devtech.user_microservice.dto.responses.UserResponse;
import com.devtech.user_microservice.entity.User;

public interface UserService {

     UserResponse getOneUser(Long userId) throws Exception;

     User getOneUserByFirstname(String firstname);
     User createOneUser(User user);
     User updateOneUser(Long userId, User user) throws Exception;
     void deleteOneUser(Long userId) throws Exception;
     UserResponse addOneHotelToUser(Long userId, Long hotelId) throws Exception;
     UserResponse addOneTourToUser(Long userId, Long tourId) throws Exception;
}
