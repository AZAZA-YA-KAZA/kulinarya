package com.example.kulinarya.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "recipes_ingredients")
@Entity
@Getter
@Setter
public class RecipesIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipe_ingredient")
    private Long idRecipeIngredient;
    @ManyToOne
    @JoinColumn(name = "id_recipe")
    private Long idRecipe;
    @ManyToOne
    @JoinColumn(name = "id_ingredient")
    private Long idIngredient;

    public RecipesIngredients(Long idRecipe, Long idIngredient) {
        this.idRecipe = idRecipe;
        this.idIngredient = idIngredient;
    }
}
