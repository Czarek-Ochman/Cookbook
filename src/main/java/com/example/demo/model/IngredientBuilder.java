package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IngredientBuilder {
    private String name;
    private String amount;
    private Long idRecipe;
}