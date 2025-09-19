package com.example.kulinarya.repository;

import com.example.kulinarya.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    @Modifying
    @Query("UPDATE Manage m SET m.name = :name WHERE m.id = :id")
    void updateNameById(@Param("id_recipe") Integer idRecipe, @Param("title") String title,
                        @Param("description") String description, @Param("photo_url") String photo_Url);
}
