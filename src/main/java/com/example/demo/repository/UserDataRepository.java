package com.example.demo.repository;

import com.example.demo.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Long> {

    public UserData findByUsername(String username);
}