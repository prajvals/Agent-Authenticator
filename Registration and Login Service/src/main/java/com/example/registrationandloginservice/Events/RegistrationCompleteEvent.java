package com.example.registrationandloginservice.Events;

import com.example.registrationandloginservice.Entity.Users;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private Users user;
    private String applicationUrl;

    public RegistrationCompleteEvent(Users users, String applicationUrl) {
        super(users);
        this.user = users;
        this.applicationUrl = applicationUrl;
    }
}
