package com.example.kulinarya.repository;

import com.example.kulinarya.models.Recipe;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.net.URL;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Recipe r SET r.title = :title, r.description = :description, r.photoUrl = :photoUrl " +
            "WHERE r.idRecipe = :idRecipe")
    void updateRecipeById(@Param("idRecipe") Long idRecipe,
                          @Param("title") String title,
                          @Param("description") String description,
                          @Param("photoUrl") String photoUrl);
}