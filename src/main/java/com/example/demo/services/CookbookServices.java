package com.example.demo.services;

import com.example.demo.model.Category;
import com.example.demo.model.Recipe;
import com.example.demo.repository.LoginDataRepository;
import com.example.demo.repository.RecipesRepository;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CookbookServices {

    @Autowired
    RecipesRepository recipesRepository;
    LoginDataRepository loginDataRepository;
    UsersRepository usersRepository;

    public CookbookServices(RecipesRepository recipesRepository, LoginDataRepository loginDataRepository, UsersRepository usersRepository) {
        this.recipesRepository = recipesRepository;
        this.loginDataRepository = loginDataRepository;
        this.usersRepository = usersRepository;
    }

    public String getRecipeList(Category category, Model model) {
        List<Recipe> byCategory = recipesRepository.findAll().stream()
                .filter(r -> r.getCategory().equals(category))
                .collect(Collectors.toList());
        String description = "nie udało sie";
        if(category.toString().equals("DRINK")){
            description = "Drinki, likiery, koktajle i inne napoje alkoholowe. Mojito, Aperol Spritz, Piña Colada, Bellini, Rossini i inne.";
        }
        model.addAttribute("description", description);
        model.addAttribute("allCategory", byCategory);
        return "list";
    }

    public String getRecipeInformation(@RequestParam Long id, Model model) {
        Optional<Recipe> recipeOptional = recipesRepository.findById(id);
        model.addAttribute("recipe", recipeOptional);
        return "recipe";
    }

}
