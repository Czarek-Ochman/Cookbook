package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Recipe;
import com.example.demo.model.UserBuilder;
import com.example.demo.repository.RecipesRepository;
import com.example.demo.services.CookbookServices;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class homeController {


    CookbookServices cookbookServices;
UserService userService;
RecipesRepository recipesRepository;

    @Autowired
    public homeController(CookbookServices cookbookServices, UserService userService, RecipesRepository recipesRepository) {
        this.cookbookServices = cookbookServices;
        this.userService = userService;
        this.recipesRepository = recipesRepository;
    }



    @GetMapping("/")
    public String getHome(Model model, Principal principal) {
        return cookbookServices.getContentHome(model, principal);
    }



    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/rejestracja")
    public String register(Model model) {
        UserBuilder userBuilder = new UserBuilder();
        model.addAttribute("add", userBuilder);
        return "register";
    }

    @PostMapping("/rejestracja")
    public String adding(UserBuilder userBuilder) {
        userService.saveUser(userBuilder.getFirstName(),userBuilder.getLastName(),userBuilder.getUsername(),userBuilder.getPassword());
        return "home";
    }

    @GetMapping("/kategorie")
    public String getCategories() {
        return "category";
    }

    @GetMapping("/przepisy")
    public String getList(@RequestParam Category category, Model model, Principal principal) {
        return cookbookServices.getRecipeList(category,model);
    }

    @GetMapping("/przepis")
    public String getRecipe(@RequestParam Long id, Model model) {
        return cookbookServices.getRecipeInformation(id, model);
    }

    @GetMapping("/panel-uzytkownika")
    public String getUserPanel(Model model,Principal principal){
      return  cookbookServices.getUserRecipes(model, principal);
    }

    @GetMapping("/kasowanie")
    public String deleteRecipe(@RequestParam Long id) {
        cookbookServices.deleteById(id);
        return "redirect:/panel-uzytkownika";
    }

    @GetMapping("/skasuj")
    public String deleteIngredient(@RequestParam Long id) {
        cookbookServices.deleteIngredientById(id);
        return "redirect:/panel-uzytkownika";
    }

    @GetMapping("/edytowanie")
    public String editRecipe(@RequestParam Long id, Model model) {
        return cookbookServices.getRecipeForEditing(id, model);
    }


    @PostMapping("/edytowanie")
    public String edited(@RequestParam Long id, Recipe newRecipe) {
        return cookbookServices.editedRecipe(id, newRecipe);
    }


}
