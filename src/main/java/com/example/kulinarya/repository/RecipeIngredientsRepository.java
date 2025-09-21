package com.example.kulinarya.repository;

import com.example.kulinarya.models.RecipesIngredients;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.net.URL;
import java.util.List;

public interface RecipeIngredientsRepository extends JpaRepository<RecipesIngredients, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM RecipeIngredients r WHERE r.idRecipe = :idRecipe AND r.idIngredient = :idIngredient")
    void deleteById(@Param("idRecipe") Long idRecipe,
                    @Param("idIngredient") Long idIngredient);
    @Modifying
    @Transactional
    @Query("SELECT ri.count, ri.unit, i.name FROM RecipeIngredients ri" +
            "JOIN Ingredient i ON i.idIngredient = ri.idIngredient" +
            "WHERE ri.idRecipe = :idRecipe")
    List<Object[]> getListIngredientByRecipe(@Param("idRecipe") Long idRecipe);
}
