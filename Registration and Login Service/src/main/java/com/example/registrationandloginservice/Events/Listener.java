package com.example.registrationandloginservice.Events;

import com.example.registrationandloginservice.Entity.Users;
import com.example.registrationandloginservice.Enums.VerificationEnums;
import com.example.registrationandloginservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
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
//        String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;
        userService.configureAndSendMail(token,userService.generateURL(event.getApplicationUrl(), token, VerificationEnums.VerifyRegistration));

    }
}
