package com.example.kulinarya.repository;

import com.example.kulinarya.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    @Query("SELECT idIngredient FROM Ingredient WHERE name = :name")
    Long getIdByName(@Param("name") String name);
}
