package com.example.kulinarya.repository;

import com.example.kulinarya.models.RecipesIngredients;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.net.URL;

public interface RecipeIngredientsRepository extends JpaRepository<RecipesIngredients, Integer> {

}
