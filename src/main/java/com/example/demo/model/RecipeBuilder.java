package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecipeBuilder {
    private String title;
    private String description;
    private String img;
    private Category category;
}
