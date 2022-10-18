package com.example.registrationandloginservice.Events;

import com.example.registrationandloginservice.Entity.Users;
import com.example.registrationandloginservice.Entity.VerificationToken;
import com.example.registrationandloginservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class Listener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //this would be the action where in we would be creating a token first
        //and send mail to the user

        Users users = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationToken(token,users);
        userService.sendVerificationTokenInMail(token);

    }
}
