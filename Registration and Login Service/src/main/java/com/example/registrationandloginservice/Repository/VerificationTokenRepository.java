package com.example.registrationandloginservice.Repository;

import com.example.registrationandloginservice.Entity.Users;
import com.example.registrationandloginservice.Entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
    VerificationToken findByToken(String token);

    VerificationToken findByUsers(Users users);
}
