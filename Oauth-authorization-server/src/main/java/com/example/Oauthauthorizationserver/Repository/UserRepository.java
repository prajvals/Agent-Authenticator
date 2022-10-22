package com.example.Oauthauthorizationserver.Repository;

import com.example.Oauthauthorizationserver.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUserName(String firstName);
}
