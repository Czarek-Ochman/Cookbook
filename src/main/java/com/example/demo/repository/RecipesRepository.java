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


    public List<Recipe> findByCategory(String category);

    @Query("SELECT r FROM Recipe r " +
            "WHERE r.user.userData.username = :username")
    public List<Recipe> findAllByUserUserDataUsername(String username);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Recipe r set r.title =:title, r.description = :description,r.img = :img   where r.id =:id")
    void update(@Param("title") String title, @Param("description") String description, @Param("img") String img,
                         @Param("id")Long id);

    @Query("SELECT r FROM Recipe r " +
            "WHERE r.title LIKE CONCAT('%',:title, '%')")
    List<Recipe> getAuctionsWithTitleAndColor(String title);

    public List<Recipe> findTop4ByOrderByRatingDesc();

}
