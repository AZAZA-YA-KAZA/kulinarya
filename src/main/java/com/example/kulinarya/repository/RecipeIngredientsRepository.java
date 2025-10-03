package com.example.kulinarya.repository;

import com.example.kulinarya.models.RecipesIngredients;
import jakarta.persistence.Column;
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
    @Query("DELETE FROM RecipesIngredients r WHERE r.idRecipe = :idRecipe AND r.idIngredient = :idIngredient")
    void deleteById(@Param("idRecipe") Long idRecipe,
                    @Param("idIngredient") Long idIngredient);

    @Query("SELECT ri.count, ri.unit, i.name FROM RecipesIngredients ri " +
            "JOIN Ingredient i ON i.idIngredient = ri.idIngredient " +
            "WHERE ri.idRecipe = :idRecipe")
    List<Object[]> getListIngredientByRecipe(@Param("idRecipe") Long idRecipe);
    @Query("UPDATE RecipesIngredients i SET i.name = :name AND i.count = :count AND i.unit = :unit" +
            "WHERE i.idIngredient = :idIngredient AND i.idRecipe = :idRecipe")
    void updateIngredientById (@Param("idRecipe") Long idRecipe,
                               @Param("idIngredient") Long idIngredient,
                               @Param("name") String name,
                               @Param("count") int count,
                               @Param("name") String unit);
    @Query("SELECT ri FROM RecipesIngredients ri WHERE i.idIngredient = :idIngredient AND i.idRecipe = :idRecipe")
    RecipesIngredients getIngredientRecipe (@Param("idRecipe") Long idRecipe,
                               @Param("idIngredient") Long idIngredient);
}
