package com.example.registrationandloginservice.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private static final int EXPIRATION_TIME = 10;
    private String token;

    private Date expirationDate;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",//possible error at this place
    nullable = false )
    private Users users;

    public VerificationToken(Users users, String token) {
        super();
        this.users = users;
        this.token = token;
        this.expirationDate = calculateTokenExpirationTime(EXPIRATION_TIME);
    }

    public VerificationToken(String token)
    {
        super();
        this.token = token;
        this.expirationDate = calculateTokenExpirationTime(EXPIRATION_TIME);
    }


    private Date calculateTokenExpirationTime(int expirationTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,expirationTime);
        return new Date(calendar.getTime().getTime());
    }


}
