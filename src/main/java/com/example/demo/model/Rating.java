package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isRated;
    private String username;

    @ManyToOne
    private Recipe recipe;

    public Rating(boolean isRated, String username, Recipe recipe) {
        this.isRated = isRated;
        this.username = username;
        this.recipe = recipe;
    }
}