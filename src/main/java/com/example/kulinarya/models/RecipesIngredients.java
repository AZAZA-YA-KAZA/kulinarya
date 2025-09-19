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
    @Column(name = "id_recipe_ingredients")
    private Long idRecipeIngredients;
    @ManyToOne
    @JoinColumn(name = "id_recipe")
    private Recipe recipe;
    @ManyToOne
    @JoinColumn(name = "id_ingredients")
    private Ingredient ingredients;
}
