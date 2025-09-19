package com.example.kulinarya.repository;

import com.example.kulinarya.models.RecipesIngredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientsRepository extends JpaRepository<RecipesIngredients, Integer> {
}
