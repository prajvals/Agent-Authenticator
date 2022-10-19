package com.example.registrationandloginservice.Repository;

import com.example.registrationandloginservice.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByFirstName(String firstName);
}
