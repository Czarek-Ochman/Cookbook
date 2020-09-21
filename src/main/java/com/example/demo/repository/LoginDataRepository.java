package com.example.demo.repository;

import com.example.demo.model.LoginData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDataRepository extends JpaRepository<LoginData, Long> {
}
