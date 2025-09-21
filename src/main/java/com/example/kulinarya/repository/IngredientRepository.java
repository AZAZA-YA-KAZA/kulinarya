package com.example.kulinarya.repository;

import com.example.kulinarya.models.Ingredient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    @Modifying
    @Transactional
    @Query("SELECT idIngredient FROM Ingredient WHERE name = :name")
    Long getIdByName(@Param("name") String name);
}
