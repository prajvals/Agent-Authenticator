package com.example.registrationandloginservice.service;

import com.example.registrationandloginservice.Entity.Users;
import com.example.registrationandloginservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public List<Users> registerUser(Users users) {
        userRepository.save(users);
        return userRepository.findAll();
    }
}
