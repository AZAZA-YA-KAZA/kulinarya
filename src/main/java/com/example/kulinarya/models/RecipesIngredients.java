package com.example.kulinarya.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "recipe_ingredient")
@Entity
@Data
@NoArgsConstructor
public class RecipesIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipe_ingredient")
    private Long idRecipeIngredient;
    @Column(name = "id_recipe")
    private Long idRecipe;
    @Column(name = "id_ingredient")
    private Long idIngredient;
    @Column(name = "count")
    private int count;
    @Column(name = "unit")
    private String unit;

    public RecipesIngredients(Long idRecipe, Long idIngredient, int count, String unit) {
        this.idRecipe = idRecipe;
        this.idIngredient = idIngredient;
        this.count = count;
        this.unit = unit;
    }
}
