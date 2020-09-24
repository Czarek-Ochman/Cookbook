package com.example.demo.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserBuilder {
    private String firstName;
    private String lastName;
    private String username;
    private String password;

}
