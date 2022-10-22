package com.example.Oauthauthorizationserver.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotEmpty(message = "userName cannot be empty")
    @NotBlank(message = "userName cannot be Null")
    private String userName;
    @NotEmpty(message = "First Name cannot be empty")
    @NotBlank(message = "First Name cannot be Null")
    @Column(unique = true)
    private String firstName;
    private String lastName;
    @NotEmpty(message = "Email cannot be Empty")
    @NotBlank(message = "Email cannot be Blank")
    @Column(unique = true) //adding a message to unique requires some more work will take it up later
//    https://codingexplained.com/coding/java/hibernate/unique-field-validation-using-hibernate-spring a brilliant article on it
    @Email(message = "Please enter a proper email address")
    private String email;
    @Column(length = 60)
    @NotEmpty(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be blank")
    private String password;
    @NotEmpty(message = "Confirm Password cannot be null")
    @NotBlank(message = "Confirm Password cannot be null")
    private String confirmPassword;
    private String role;
    private Boolean enabled = false;

}
