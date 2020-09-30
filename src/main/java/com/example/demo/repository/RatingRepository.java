package com.example.demo.repository;

import com.example.demo.model.Rating;
import com.example.demo.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    public Rating findByUsernameAndRecipe(String username, Recipe recipe);
}
