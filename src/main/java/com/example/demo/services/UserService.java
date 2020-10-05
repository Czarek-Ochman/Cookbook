package com.example.demo.services;

import com.example.demo.model.UserData;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.repository.UserDataRepository;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UsersRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private PasswordEncoder passwordEncoder;
    private UserDataRepository userDataRepository;

    @Autowired
    public UserService(UsersRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, UserDataRepository userDataRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDataRepository = userDataRepository;
    }

    public void saveUser(String firstName, String lastName, String username, String password) {
        UserData userData = new UserData(username, passwordEncoder.encode(password), true);
        User user = new User(firstName, lastName, userData);
        userDataRepository.save(userData);
        userRepository.save(user);
        UserRole userRole = new UserRole(username, "ROLE_USER");
        userRoleRepository.save(userRole);
    }
}