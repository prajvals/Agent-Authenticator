package com.example.registrationandloginservice.ExceptionHandlers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class ValidationErrors {
    private String validationErrorMessage;
}
