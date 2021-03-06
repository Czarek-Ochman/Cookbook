package com.example.demo.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String amount;

    @ManyToOne()
    private Recipe recipe;

    public Ingredient(String name, String amount, Recipe recipe) {
        this.name = name;
        this.amount = amount;
        this.recipe = recipe;
    }
}