package com.devtech.user_microservice.service.concretes;

import com.devtech.user_microservice.entity.User;
import com.devtech.user_microservice.repository.UserRepository;
import com.devtech.user_microservice.security.JwtUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsManager implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String firstname) throws UsernameNotFoundException {
        User user = userRepository.findByFirstname(firstname);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).get();
        return JwtUserDetails.create(user);
    }
}
