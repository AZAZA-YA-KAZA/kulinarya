package com.example.kulinarya.service;

import com.example.kulinarya.models.*;
import com.example.kulinarya.repository.IngredientRepository;
import com.example.kulinarya.repository.RecipeIngredientsRepository;
import com.example.kulinarya.repository.RecipeRepository;
import com.example.kulinarya.repository.StepRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Ingredient addIngredient(Long idRecipe, String name, int count, String unit) throws Exception {
        Long idIngredient = ingredientRepository.getIdByName(name);
        Ingredient ingredient;
        if (idIngredient == null) {
            ingredient = new Ingredient(name);
            ingredientRepository.save(ingredient);
        }
        else ingredient = ingredientRepository.findById(Math.toIntExact(idIngredient))
                .orElseThrow(()-> new Exception("Not ingredient"));
        RecipesIngredients recipesIngredients = new RecipesIngredients(
                idRecipe, ingredient.getIdIngredient(),count, unit);
        recipeIngredientsRepository.save(recipesIngredients);
        return ingredient;
    }

    public Recipe updateRecipe(Long idRecipe, RecipeRequest recipeRequest) throws Exception {
        recipeRepository.updateRecipeById(idRecipe, recipeRequest.title(), recipeRequest.description(),
                recipeRequest.photoUrl());
        Recipe recipe = recipeRepository.findById(Math.toIntExact(idRecipe)).orElseThrow(() ->
                new Exception("Not fount Recipe"));
        return recipe;
    }

    public Step updateStep(Long idStep, StepRequest stepRequest) throws Exception {
        stepRepository.updateStepById(idStep, stepRequest.stepDescription(), stepRequest.stepOrder());
        Step step = stepRepository.findById(Math.toIntExact(idStep)).orElseThrow(()-> new Exception("Not fount step"));
        return step;
    }

    public String deleteRecipe(Long idRecipe) {
        recipeRepository.deleteById(Math.toIntExact(idRecipe));
        return "Deleted";
    }

    public String deleteStep(Long idStep) {
        stepRepository.deleteById(Math.toIntExact(idStep));
        return "Deleted";
    }

    public String deleteIngredient(Long idRecipe, Long idIngredient) {
        recipeIngredientsRepository.deleteById(idRecipe, idIngredient);
        return "Deleted";
    }

    public Recipe getRecipe(Long idRecipe) throws Exception {
        return recipeRepository.findById(Math.toIntExact(idRecipe)).orElseThrow(()-> new Exception("Not found recipe"));
    }

    public List<Step> getStep(Long idRecipe) {
        return stepRepository.getListStepByRecipe(idRecipe);
    }

    public List<Object[]> getIngredient(Long idRecipe) {
        return recipeIngredientsRepository.getListIngredientByRecipe(idRecipe);
    }
}
