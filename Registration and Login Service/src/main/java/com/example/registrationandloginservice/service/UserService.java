package com.example.registrationandloginservice.service;

import com.example.registrationandloginservice.Entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<Users> registerUser(Users users);

    List<Users> getAllUser();
}
