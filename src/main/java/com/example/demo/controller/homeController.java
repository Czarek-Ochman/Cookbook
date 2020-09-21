package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipesRepository;
import com.example.demo.services.CookbookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class homeController {


    CookbookServices cookbookServices;

    @Autowired
    public homeController(CookbookServices cookbookServices) {
        this.cookbookServices = cookbookServices;
    }

    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("/logowanie")
    public String login() {
        return "login";
    }

    @GetMapping("/rejestracja")
    public String register() {
        return "register";
    }

    @GetMapping("/kategorie")
    public String getCategories() {
        return "category";
    }

    @GetMapping("/przepisy")
    public String getList(@RequestParam Category category, Model model) {
        return cookbookServices.getRecipeList(category,model);
    }


    @GetMapping("/przepis")
    public String getRecipe(@RequestParam Long id, Model model) {
        return cookbookServices.getRecipeInformation(id, model);
    }


}
