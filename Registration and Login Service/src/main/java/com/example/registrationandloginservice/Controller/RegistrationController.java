package com.example.registrationandloginservice.Controller;

import com.example.registrationandloginservice.Entity.Users;
import com.example.registrationandloginservice.Events.RegistrationCompleteEvent;
import com.example.registrationandloginservice.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @PostMapping("/CreateNewUser")
    public ResponseEntity<List<Users>> registerUser(@Valid @RequestBody Users users)
    {
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(users,"url"));

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(users));
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers()
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

}
