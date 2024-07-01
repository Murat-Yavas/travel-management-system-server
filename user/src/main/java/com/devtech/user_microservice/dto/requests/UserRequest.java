package com.devtech.user_microservice.dto.requests;

import lombok.Data;

@Data
public class UserRequest {

    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private String phoneNumber;
}
