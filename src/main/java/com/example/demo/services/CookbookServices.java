package com.example.demo.services;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CookbookServices {

    private RecipesRepository recipesRepository;
    private UserDataRepository userDataRepository;
    private UsersRepository usersRepository;
    private IngredientRepository ingredientRepository;
    private RatingRepository ratingRepository;

    @Autowired
    public CookbookServices(RecipesRepository recipesRepository, UserDataRepository userDataRepository, UsersRepository usersRepository, IngredientRepository ingredientRepository, RatingRepository ratingRepository) {
        this.recipesRepository = recipesRepository;
        this.userDataRepository = userDataRepository;
        this.usersRepository = usersRepository;
        this.ingredientRepository = ingredientRepository;
        this.ratingRepository = ratingRepository;
    }

    public String getRecipeList(Category category, Model model) {
        List<Recipe> byCategory;

        if (category.toString().equals("ALL")) {
            byCategory = recipesRepository.findAll();
        } else if (category.toString().equals("RATING")) {
            byCategory = recipesRepository.findAndSortRecipe();
        } else {
            byCategory = recipesRepository.findAllByCategory(category);
        }
        String description = category.getDescription();
        String title = category.getTitle();

        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("allCategory", byCategory);
        return "list";
    }

    public String getRecipeInformation(Long id, boolean rate, Model model, Principal principal) {
        try {
            Optional<Recipe> recipeOptional = recipesRepository.findById(id);
            Recipe recipe = recipesRepository.findById(id).get();
            List<Ingredient> allByRecipe = ingredientRepository.findAllByRecipe(recipe);

            if (rate) {
                int rating = recipe.getRating() + 1;
                ratingRepository.save(new Rating(true, getUser(principal), recipe));
                recipesRepository.update(rating, id);
            }

            if (ratingRepository.findByUsernameAndRecipe(getUser(principal), recipe) != null) {
                rate = true;
            }

            model.addAttribute("rate", rate);
            model.addAttribute("ingredient", allByRecipe);
            model.addAttribute("recipe", recipeOptional);
        } catch (NoSuchElementException e) {
            System.out.println("Błąd id ocenianego przepisu");
        }
        return "recipe";
    }

    public String getUserRecipes(Model model, Principal principal) {
        String name = principal.getName();
        List<Recipe> recipes = recipesRepository.findAllByUserUserDataUsername(name);
        model.addAttribute("name", name);
        model.addAttribute("recipe", recipes);
        return "userPanel";
    }

    public void deleteById(Long id) {
        recipesRepository.deleteById(id);

    }

    public String getRecipeForEditing(@RequestParam Long id, Model model) {
        try {
            Recipe recipe = recipesRepository.findById(id).get();
            List<Ingredient> allByRecipe = ingredientRepository.findAllByRecipe(recipe);
            Recipe newRecipe = new Recipe();
            model.addAttribute("byRecipe", allByRecipe);
            model.addAttribute("recipe", newRecipe);
            model.addAttribute("oldRecipe", recipe);
            model.addAttribute("mode", "edited");
        } catch (NoSuchElementException e) {
            System.out.println("Błędne id edytowanego przepisu! -> Wczytywanie");
        }
        return "edit";
    }

    public String editedRecipe(Recipe newRecipe) {
        recipesRepository.save(newRecipe);
        return "redirect:/";
    }

    public String getIngredientForEditing(@RequestParam Long id, Model model) {
        try {
            Ingredient ingredient = ingredientRepository.findById(id).get();
            Ingredient newIngredient = new Ingredient();
            model.addAttribute("ingredient", newIngredient);
            model.addAttribute("oldIngredient", ingredient);
            model.addAttribute("mode", "edited");
        } catch (NoSuchElementException e) {
            System.out.println("Błędne id edytowanego składnika! -> Wczytywanie");
        }
        return "editIngredient";
    }

    public String editedIngredient(Ingredient newIngredient) {
        ingredientRepository.save(newIngredient);
        return "redirect:/panel-uzytkownika";
    }

    public void deleteIngredientById(Long id) {
        ingredientRepository.deleteById(id);
    }

    public List<Recipe> getFourRecipeByRating() {
        return recipesRepository.findTop4ByOrderByRatingDesc();
    }

    public String getContentHome(Model model, Principal principal) {
        List<Recipe> fourRecipeByRating = getFourRecipeByRating();
        Recipe recipe = fourRecipeByRating.get(0);
        Recipe recipe2 = fourRecipeByRating.get(1);
        Recipe recipe3 = fourRecipeByRating.get(2);
        Recipe recipe4 = fourRecipeByRating.get(3);
        String name = getUser(principal);
        model.addAttribute("recipe1", recipe);
        model.addAttribute("recipe2", recipe2);
        model.addAttribute("recipe3", recipe3);
        model.addAttribute("recipe4", recipe4);
        model.addAttribute("name", name);
        return "home";
    }

    private String getUser(Principal principal) {
        String name;
        if (principal == null) {
            name = "Użytkownik niezalogowany";
        } else {
            name = principal.getName();
        }
        return name;
    }

    public void save(String title, String description, String img, Category category, Principal principal) {
        try {
            List<Ingredient> ingredients = new ArrayList<>();
            UserData byUsername = userDataRepository.findByUsername(principal.getName());
            Optional<User> byId = usersRepository.findById(byUsername.getId());
            Recipe recipe = new Recipe(title, description, img, category, ingredients, byId.get());
            recipesRepository.save(recipe);
        } catch (NoSuchElementException e) {
            System.out.println("Błąd id przepisu podczas zapisywania!");
        }
    }

    public void addIngredient(IngredientBuilder ingredientBuilder) {
        try {
            Recipe recipe = recipesRepository.findById(ingredientBuilder.getIdRecipe()).get();
            Ingredient newIngredient = new Ingredient(ingredientBuilder.getName(), ingredientBuilder.getAmount(), recipe);
            ingredientRepository.save(newIngredient);
        } catch (NoSuchElementException e) {
            System.out.println("Błąd id przepisu podczas dodawania!");
        }
    }

    public String getRecipeForAdding(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        model.addAttribute("mode", "adding");
        return "add";
    }

    public String getIngredientForAdding(Model model, Principal principal) {
        IngredientBuilder ingredientBuilder = new IngredientBuilder();
        String name = principal.getName();
        List<Recipe> recipes = recipesRepository.findAllByUserUserDataUsername(name);
        model.addAttribute("recipe", recipes);
        model.addAttribute("add", ingredientBuilder);
        return "addIngredient";
    }
}