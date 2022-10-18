package com.example.registrationandloginservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendSimpleEmail(String toEmail, String body, String subject)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("prajvaltheking@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);
    }



}
