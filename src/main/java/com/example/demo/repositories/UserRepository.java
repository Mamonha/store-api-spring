package com.example.demo.repositories;

import com.example.demo.enums.UserType;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserType(UserType userType);

    List<User> findByUserTypeAndIdadeBetween(UserType userType, Integer minAge, Integer maxAge);
}
