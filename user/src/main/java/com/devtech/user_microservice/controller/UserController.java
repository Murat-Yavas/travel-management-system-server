package com.devtech.user_microservice.controller;

import com.devtech.user_microservice.dto.responses.UserResponse;
import com.devtech.user_microservice.entity.User;
import com.devtech.user_microservice.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> receiveOneUser(@PathVariable Long userId) throws Exception {
        return new ResponseEntity<>(userService.getOneUser(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addOneUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createOneUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> editOneUser(@PathVariable Long userId, @RequestBody User user) throws Exception {
        return new ResponseEntity<>(userService.updateOneUser(userId, user), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteOneUser(@PathVariable Long userId) throws Exception {
        userService.deleteOneUser(userId);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    @PutMapping("/{userId}/hotel/{hotelId}")
    public ResponseEntity<UserResponse> addHotelToUser(@PathVariable Long userId, @PathVariable Long hotelId) throws Exception {
        return new ResponseEntity<>(userService.addOneHotelToUser(userId,hotelId), HttpStatus.OK);
    }

    @PutMapping("/{userId}/tour/{tourId}")
    public ResponseEntity<UserResponse> addTourToUser(@PathVariable Long userId, @PathVariable Long tourId) throws Exception {
        return new ResponseEntity<>(userService.addOneTourToUser(userId, tourId), HttpStatus.OK);
    }
}
