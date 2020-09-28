package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Ingredient;
import com.example.demo.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    public void deleteAllByRecipe(Optional<Recipe> recipe);

    public List<Ingredient> findAllByRecipe(Recipe recipe);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Ingredient i set i.name = :name, i.amount = :amount  where i.id =:id")
    void update(@Param("name") String name, @Param("amount") String amount, @Param("id") Long id);
}