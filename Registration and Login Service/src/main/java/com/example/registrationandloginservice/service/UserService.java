package com.example.registrationandloginservice.service;

import com.example.registrationandloginservice.Entity.Users;
import com.example.registrationandloginservice.Enums.VerificationEnums;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<Users> registerUser(Users users);

    List<Users> getAllUser();

    void saveVerificationToken(String token, Users users);

    void configureAndSendMail(String token, String url);

    String verifyTokenForRegistration(String token);

    String getVerificationToken(Users users);

    Users getUserByUserName(String userName);

    String generateURL(String applicationUrl, String token, VerificationEnums action);

    Boolean verifyTokenForForgetPassword(String token);

    String updatePassword(String newPassword, String token);
}
