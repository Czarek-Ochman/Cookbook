package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @OneToOne(cascade = CascadeType.PERSIST)
    private UserData userData;

    @OneToMany(mappedBy = "user")
    private List<Recipe> recipeList;

    public User(String firstName, String lastName, UserData userData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userData = userData;
    }
}