package com.devtech.user_microservice.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private String accessToken;
    private String message;
    private String firstname;
    private Long userId;
    private String lastname;
    private String password;
    private String email;
    private String phoneNumber;
}
