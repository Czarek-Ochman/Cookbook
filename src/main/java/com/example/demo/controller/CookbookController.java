package com.example.demo.controller;

import com.example.demo.model.*;
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
public class CookbookController {

    CookbookServices cookbookServices;
    UserService userService;

    @Autowired
    public CookbookController(CookbookServices cookbookServices, UserService userService, RecipesRepository recipesRepository) {
        this.cookbookServices = cookbookServices;
        this.userService = userService;
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
        userService.saveUser(userBuilder.getFirstName(), userBuilder.getLastName(), userBuilder.getUsername(), userBuilder.getPassword());
        return "home";
    }

    @GetMapping("/kategorie")
    public String getCategories() {
        return "category";
    }

    @GetMapping("/ocen")
    public String rate(@RequestParam Long id) {
        return "category";
    }

    @GetMapping("/przepisy")
    public String getList(@RequestParam Category category, Model model, Principal principal) {
        return cookbookServices.getRecipeList(category, model);
    }

    @GetMapping("/przepis")
    public String getRecipe(@RequestParam Long id, @RequestParam(required = false) boolean rate, Model model, Principal principal) {
        return cookbookServices.getRecipeInformation(id, rate, model, principal);
    }

    @GetMapping("/panel-uzytkownika")
    public String getUserPanel(Model model, Principal principal) {
        return cookbookServices.getUserRecipes(model, principal);
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
    public String edited(Recipe newRecipe) {
        return cookbookServices.editedRecipe(newRecipe);
    }

    @GetMapping("/edytuj-skladnik")
    public String editIngredient(@RequestParam Long id, Model model) {
        return cookbookServices.getIngredientForEditing(id, model);
    }

    @PostMapping("/edytuj-skladnik")
    public String editedIngredient(Ingredient newIngredient) {
        return cookbookServices.editedIngredient(newIngredient);
    }

    @GetMapping("/dodawanie")
    public String add(Model model) {
        return cookbookServices.getRecipeForAdding(model);
    }

    @PostMapping("/dodawanie")
    public String adding(Recipe recipe, Principal principal) {
        cookbookServices.save(recipe.getTitle(), recipe.getDescription(), recipe.getImg(), recipe.getCategory(), principal);
        return "redirect:/dodawanie-skladniki";
    }

    @GetMapping("/dodawanie-skladniki")
    public String addIngredient(Model model, Principal principal) {
        return cookbookServices.getIngredientForAdding(model, principal);
    }

    @PostMapping("/dodawanie-skladniki")
    public String addingIngredient(IngredientBuilder ingredientBuilder) {
        cookbookServices.addIngredient(ingredientBuilder);
        return "redirect:/dodawanie-skladniki";
    }
}