package com.devtech.user_microservice.service.concretes;

import com.devtech.user_microservice.client.HotelClient;
import com.devtech.user_microservice.client.TourClient;
import com.devtech.user_microservice.dto.responses.UserResponse;
import com.devtech.user_microservice.entity.User;
import com.devtech.user_microservice.entity.UserHotel;
import com.devtech.user_microservice.entity.UserTour;
import com.devtech.user_microservice.external.HotelDto;
import com.devtech.user_microservice.external.TourDto;
import com.devtech.user_microservice.repository.UserRepository;
import com.devtech.user_microservice.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private HotelClient hotelClient;
    private TourClient tourClient;
    ArrayList<UserHotel> hotelTempList;
    ArrayList<UserTour> tourTempList;
    private PasswordEncoder passwordEncoder;



    @Override
    public UserResponse getOneUser(Long userId) throws Exception {
        User foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User with id: " + userId + " not found"));
        return new UserResponse(foundUser);
    }

    @Override
    public User getOneUserByFirstname(String firstname) {
        User foundUser = userRepository.findByFirstname(firstname);
        return foundUser;
    }

    @Override
    public User createOneUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateOneUser(Long userId, User user) throws Exception {
        User foundUser = userRepository.findById(userId).orElse(null);
        if(foundUser != null) {
            foundUser.setId(user.getId());
            foundUser.setFirstname(user.getFirstname());
            foundUser.setLastname(user.getLastname());
            foundUser.setPassword(foundUser.getPassword());
            foundUser.setEmail(user.getEmail());
            foundUser.setPhoneNumber(user.getPhoneNumber());
            return userRepository.save(foundUser);
        } else throw new Exception("User with id: " + userId + " not found");
    }

    @Override
    public void deleteOneUser(Long userId) throws Exception {
        User foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User with id: " + userId + " not found"));
        userRepository.deleteById(userId);
    }

    @Override
    public UserResponse addOneHotelToUser(Long userId, Long hotelId) throws Exception{
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User with id: " + userId + " not found"));;

        UserHotel userHotel = new UserHotel(hotelId);

        hotelTempList.add(userHotel);
        user.setUserHotels(hotelTempList);
        return new UserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse addOneTourToUser(Long userId, Long tourId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User with id: " + userId + " not found"));;

        UserTour userTour = new UserTour(tourId);

        tourTempList.add(userTour);
        user.setUserTours(tourTempList);
        return new UserResponse(userRepository.save(user));
    }
}
