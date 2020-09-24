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
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredients;

    @ManyToOne
   private User user;

    public Category getCategory() {
        return category;
    }
}
