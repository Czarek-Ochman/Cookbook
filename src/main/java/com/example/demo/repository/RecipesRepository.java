package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RecipesRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT r FROM Recipe r " +
            "WHERE r.category = :category")
    public List<Recipe> findAllByCategory(Category category);

    @Query("SELECT r FROM Recipe r " +
            "WHERE r.user.userData.username = :username")
    public List<Recipe> findAllByUserUserDataUsername(String username);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Recipe r set r.title =:title, r.description = :description,r.img = :img  where r.id =:id")
    void update(@Param("title") String title, @Param("description") String description, @Param("img") String img,
                @Param("id") Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Recipe r set r.rating =:rating  where r.id =:id")
    void update(@Param("rating") int rating, @Param("id") Long id);

    public List<Recipe> findTop4ByOrderByRatingDesc();

    @Query("SELECT r FROM Recipe r ORDER BY r.rating DESC")
    List<Recipe> findAndSortRecipe();
}