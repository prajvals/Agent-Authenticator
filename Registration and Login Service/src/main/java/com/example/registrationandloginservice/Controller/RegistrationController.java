package com.example.registrationandloginservice.Controller;

import com.example.registrationandloginservice.Entity.Users;
import com.example.registrationandloginservice.Enums.VerificationEnums;
import com.example.registrationandloginservice.Events.RegistrationCompleteEvent;
import com.example.registrationandloginservice.service.EmailSenderService;
import com.example.registrationandloginservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class RegistrationController {
    @Autowired
    EmailSenderService emailSenderService;
    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("/CreateNewUser")
    public ResponseEntity<List<Users>> registerUser(@Valid @RequestBody Users users, final HttpServletRequest httpServletRequest) {
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(users, applicationUrl(httpServletRequest)));
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(users));
    }
    @GetMapping("/verifyRegistration")
    public String VerifyRegistrationToken(@RequestParam("token") String token) {
//        if(userService.verifyToken(token))
//        {
//            return "User verified successfully";
//        }
//        return "User cannot be found, verification failed";

        return userService.verifyTokenForRegistration(token);
    }

    @GetMapping("/resendToken")
    public String ResendVerificationToken(@RequestParam("userName") String userName, final HttpServletRequest httpServletRequest) {
        Users user = userService.getUserByUserName(userName);
        userService.configureAndSendMail(userService.getVerificationToken(user), userService.generateURL(applicationUrl(httpServletRequest), userService.getVerificationToken(user), VerificationEnums.VerifyRegistration));
        return "Token Sent";
    }

    @GetMapping("/forgotPasswordInitiation")
    public String ResetPassword(@RequestParam("userName") String userName, @RequestParam("newPassword") String newPassword, final HttpServletRequest httpServletRequest)
    {
        String token = UUID.randomUUID().toString();
        userService.saveVerificationToken(token,userService.getUserByUserName(userName));
        emailSenderService.sendSimpleEmail(userService.getUserByUserName(userName).getEmail(), "The forget password token is " + token + " " + userService.generateURL(applicationUrl(httpServletRequest),token, VerificationEnums.ForgetPassword) + "&newPassword="+ newPassword, "Forget password mail");
        return "Forget Password verification Mail sent";

    }
    @GetMapping("/forgotPassword")
    public String VerifyForgetPassword(@RequestParam("token") String token,@RequestParam("newPassword") String newPassword)
    {
         if(userService.verifyTokenForForgetPassword(token))
         {
             return userService.updatePassword(newPassword,token);
         }
         else{
             return "Verification token invalid";
         }
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }


    private String applicationUrl(HttpServletRequest httpServletRequest) {
        return "http://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort() + httpServletRequest.getContextPath();
    }

}
