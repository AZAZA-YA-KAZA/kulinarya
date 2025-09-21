package com.example.kulinarya.service;

import com.example.kulinarya.models.*;
import com.example.kulinarya.repository.IngredientRepository;
import com.example.kulinarya.repository.RecipeIngredientsRepository;
import com.example.kulinarya.repository.RecipeRepository;
import com.example.kulinarya.repository.StepRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final RecipeRepository recipeRepository;
    private final StepRepository stepRepository;
    private final IngredientRepository ingredientRepository;
    private final RecipeIngredientsRepository recipeIngredientsRepository;

    public ProjectService(RecipeRepository recipeRepository, StepRepository stepRepository, IngredientRepository ingredientRepository, RecipeIngredientsRepository recipeIngredientsRepository) {
        this.recipeRepository = recipeRepository;
        this.stepRepository = stepRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeIngredientsRepository = recipeIngredientsRepository;
    }

    public Recipe createRecipe(RecipeRequest recipeRequest) {
        Recipe recipe = new Recipe(recipeRequest.title(),recipeRequest.description(),recipeRequest.photoUrl());
        recipeRepository.save(recipe);
        return recipe;
    }

    public Step createStep(Long idRecipe, StepRequest stepRequest) {
        Step step = new Step(idRecipe, stepRequest.stepDescription(), stepRequest.stepOrder());
        stepRepository.save(step);
        return step;
    }

    public Ingredient addIngredient(Long idRecipe, String name) {
        Ingredient ingredient = new Ingredient(name);
        ingredientRepository.save(ingredient);
        RecipesIngredients recipesIngredients = new RecipesIngredients(idRecipe, ingredientRepository.getIdByName(name));
        recipeIngredientsRepository.save(recipesIngredients);
        return ingredient;
    }

    public Recipe updateRecipe(Long idRecipe, RecipeRequest recipeRequest) throws Exception {
        Recipe recipe = recipeRepository.findById(Math.toIntExact(idRecipe)).orElseThrow(() -> new Exception("Not fount Recipe"));
        recipe.setTitle(recipeRequest.title());
        recipe.setDescription(recipeRequest.description());
        recipe.setPhotoUrl(recipeRequest.photoUrl());
        return recipe;
    }

    public Step updateStep(Long idRecipe, Long idStep, StepRequest stepRequest) {

    }
}
