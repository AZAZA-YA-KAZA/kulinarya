package com.example.kulinarya.service;

import com.example.kulinarya.models.Recipe;
import com.example.kulinarya.models.RecipeRequest;
import com.example.kulinarya.repository.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final RecipeRepository recipeRepository;

    public ProjectService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe createRecipe(RecipeRequest recipeRequest) {
        Recipe recipe = new Recipe(recipeRequest.title(),recipeRequest.description(),recipeRequest.photoUrl());
        recipeRepository.save(recipe);
        return recipe;
    }
}
