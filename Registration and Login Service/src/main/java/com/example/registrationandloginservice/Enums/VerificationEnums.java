package com.example.registrationandloginservice.Enums;

import lombok.Getter;

@Getter
public enum VerificationEnums {
    VerifyRegistration("verifyRegistration"),
    ForgetPassword("forgotPassword");

    private String action;

    VerificationEnums(String action) {
        this.action = action;
    }
}
