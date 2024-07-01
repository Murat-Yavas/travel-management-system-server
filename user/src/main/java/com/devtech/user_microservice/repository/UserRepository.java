package com.devtech.user_microservice.repository;

import com.devtech.user_microservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByFirstname(String firstname);
}
