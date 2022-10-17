package com.example.registrationandloginservice.service;

import com.example.registrationandloginservice.Entity.Users;
import com.example.registrationandloginservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<Users> registerUser(Users users) {
        System.out.println("entered tye service");
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        System.out.println("users = " + users);
        userRepository.save(users);
        return userRepository.findAll();
    }

    @Override
    public List<Users> getAllUser() {
        return userRepository.findAll();
    }
}
