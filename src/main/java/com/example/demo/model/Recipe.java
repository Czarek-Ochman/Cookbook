package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String img;
    private int rating = 0;
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredients;

    @ManyToOne
   private User user;


    public Recipe(String title, String description, String img, Category category, List<Ingredient> ingredients, User user) {
        this.title = title;
        this.description = description;
        this.img = img;
        this.category = category;
        this.ingredients = ingredients;
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }
}
