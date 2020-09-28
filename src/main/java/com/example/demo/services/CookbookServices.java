package com.example.demo.services;

import com.example.demo.model.*;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.UserDataRepository;
import com.example.demo.repository.RecipesRepository;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CookbookServices {

    @Autowired
    RecipesRepository recipesRepository;
    UserDataRepository userDataRepository;
    UsersRepository usersRepository;
    IngredientRepository ingredientRepository;
    List<Rating> ratings = new ArrayList<>();

    public CookbookServices(RecipesRepository recipesRepository, UserDataRepository userDataRepository, UsersRepository usersRepository, IngredientRepository ingredientRepository) {
        this.recipesRepository = recipesRepository;
        this.userDataRepository = userDataRepository;
        this.usersRepository = usersRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public String getRecipeList(Category category, Model model) {
        List<Recipe> byCategory;

        if (category.toString().equals("ALL")) {
            byCategory = recipesRepository.findAll();
        } else if (category.toString().equals("RATING")) {
            byCategory = recipesRepository.findAndSortRecipe();
        } else {
            byCategory = recipesRepository.findAll().stream()
                    .filter(r -> r.getCategory().equals(category))
                    .collect(Collectors.toList());
        }
        String description = "Coś poszło nie tak!";
        String title = "Coś poszło nie tak!";
        if (category.toString().equals("DRINK")) {
            title = "Napoje:";
            description = "Szukasz pysznych  przepisów na kawy, napoje bezalkoholowe lub alkoholowe? Będziesz zachwycony tą zakładką. Tutaj na pewno znajdziesz coś dla siebie!";
        } else if (category.toString().equals("SUPPER")) {
            title = "Kolacje:";
            description = "Na koniec dnia także przyda się pyszny przepis na lekką oraz uroczystą kolacje. W tej zakładce na pewno znajdziesz coś dla siebie!";
        } else if (category.toString().equals("SNACK")) {
            title = "Przekąski:";
            description = "Jesteś głodny, ale nie masz czasu gotować? Ta zakładka charakteryzuje się smacznymi przepisami na proste i szybkie przekąski.";
        } else if (category.toString().equals("DESSERT")) {
            title = "Desery:";
            description = "Słodka przerwa w ciągu dnia przyda się każdemu. Te miejsce jest idealne, aby znaleźć pyszny przepis na małe co nieco";
        } else if (category.toString().equals("DINNER")) {
            title = "Obiady:";
            description = "Szukasz pomysłu na obiad? To idealne miejsca dla ciebie! W tej zakładce znajdują się inspiracje na smakowite przepisy dań obiadowych.";
        } else if (category.toString().equals("BREAKFAST")) {
            title = "Śniadania:";
            description = "Śniadanie to najważniejszy posiłek dnia, dlatego w tym miejscu znajdziesz najróżniejsze przepisy na przepyszne śniadanie.";
        } else if (category.toString().equals("ALL")) {
            title = "Wszystkie przepisy:";
            description = "Szukasz pomysłu na danie, ale nie wiesz co chcesz zjeść? To idealne miejsca dla ciebie! W tej zakładce znajdują się inspiracje na smakowite przepisy wszystkich rodzai dań.";
        } else if (category.toString().equals("RATING")) {
            title = "Najlepiej oceniane:";
            description = "Szukasz pomysłu na danie, ale nie wiesz co chcesz zjeść? To idealne miejsca dla ciebie! W tej zakładce znajdują się nasze najlepsze przepisy";
        }

        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("allCategory", byCategory);
        return "list";
    }

    public String getRecipeInformation(Long id, boolean rate, Model model,Principal principal) {
        Optional<Recipe> recipeOptional = recipesRepository.findById(id);
        Recipe recipe = recipesRepository.findById(id).orElse(null);
        List<Ingredient> allByRecipe = ingredientRepository.findAllByRecipe(recipe);

        if (rate) {
            int rating = recipe.getRating() + 1;
            ratings.add(new Rating(recipe.getId(), true,getUser(principal)));
            recipesRepository.update(rating, id);
        }

        for (int i = 0; i < ratings.size(); i++) {
            if (ratings.get(i).getId() == recipe.getId()&& ratings.get(i).getUsername().equals(getUser(principal))) {
                rate = true;
                break;
            }
        }

        model.addAttribute("rate", rate);
        model.addAttribute("ingredient", allByRecipe);
        model.addAttribute("recipe", recipeOptional);
        return "recipe";
    }

    public String getUserRecipes(Model model, Principal principal) {
        String name = principal.getName();
        List<Recipe> recipes = recipesRepository.findAllByUserUserDataUsername(name);
        model.addAttribute("name", name);
        model.addAttribute("recipe", recipes);
        return "userPanel";
    }

    @Transactional
    public void deleteById(Long id) {
        ingredientRepository.deleteAllByRecipe(recipesRepository.findById(id));
        recipesRepository.deleteById(id);
    }

    public String getRecipeForEditing(@RequestParam Long id, Model model) {
        Recipe recipe = recipesRepository.findById(id).orElse(null);
        List<Ingredient> allByRecipe = ingredientRepository.findAllByRecipe(recipe);
        Recipe newRecipe = new Recipe();
        model.addAttribute("byRecipe", allByRecipe);
        model.addAttribute("recipe", newRecipe);
        model.addAttribute("oldRecipe", recipe);
        model.addAttribute("mode", "edited");
        return "edit";
    }

    public String editedRecipe(@RequestParam Long id, Recipe newRecipe) {
        recipesRepository.update(newRecipe.getTitle(), newRecipe.getDescription(), newRecipe.getImg(), id);
        return "redirect:/";
    }

    public String getIngredientForEditing(@RequestParam Long id, Model model) {
        Ingredient ingredient = ingredientRepository.findById(id).orElse(null);
        Ingredient newIngredient = new Ingredient();
        model.addAttribute("ingredient", newIngredient);
        model.addAttribute("oldIngredient", ingredient);
        model.addAttribute("mode", "edited");
        return "editIngredient";
    }

    public String editedIngredient(@RequestParam Long id, Ingredient newIngredient) {
        ingredientRepository.update(newIngredient.getName(), newIngredient.getAmount(), id);
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
        try {
            name = principal.getName();
        } catch (NullPointerException e) {
            name = "Użytkownik niezalogowany";
        }
        return name;
    }

    public void save(String title, String description, String img, Category category, Principal principal) {
        List<Ingredient> ingredients = new ArrayList<>();
        try {
            UserData byUsername = userDataRepository.findByUsername(principal.getName());
            Optional<User> byId = usersRepository.findById(byUsername.getId());
            Recipe recipe = new Recipe(title, description, img, category, ingredients, byId.orElse(null));
            recipesRepository.save(recipe);
        } catch (NullPointerException e) {
            System.out.println("Błąd dodawania przepisu");
        }
    }

    public void addIngredient(IngredientBuilder ingredientBuilder) {
        Recipe recipe = recipesRepository.findById(ingredientBuilder.getIdRecipe()).orElse(null);
        Ingredient newIngredient = new Ingredient(ingredientBuilder.getName(), ingredientBuilder.getAmount(), recipe);
        ingredientRepository.save(newIngredient);
    }
}