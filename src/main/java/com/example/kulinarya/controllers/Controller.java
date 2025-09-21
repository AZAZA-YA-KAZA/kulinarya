package com.example.kulinarya.controllers;

import com.example.kulinarya.models.*;
import com.example.kulinarya.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    ProjectService projectService;

    public Controller(ProjectService projectService) {
        this.projectService = projectService;
    }

    //Создание рецепта
    @PostMapping("/api/kulinare/recipe/create")
    public ResponseEntity<Recipe> createRecipe(
            @RequestBody RecipeRequest recipeRequest
            ){
        return ResponseEntity.ok(projectService.createRecipe(recipeRequest));
    }
    //Создание шага
    @PostMapping("/api/kulinare/{idRecipe}/createStep")
    public ResponseEntity<Step> createStep(
            @PathVariable Long idRecipe,
            @RequestBody StepRequest stepRequest
            ){
        return ResponseEntity.ok(projectService.createStep(idRecipe, stepRequest));
    }
    //Добавление ингредиента
    @PostMapping("/api/kulinare/{idRecipe}/addIngredient")
    public ResponseEntity<Ingredient> addIngredient(
            @PathVariable Long idRecipe,
            @RequestBody String name
            ){
        return ResponseEntity.ok(projectService.addIngredient(idRecipe, name));
    }

    //Редактирование рецепта
    @PutMapping("/api/kulinare/{idRecipe}/update")
    public ResponseEntity<Recipe> updateRecipe(
            @PathVariable Long idRecipe,
            @RequestBody RecipeRequest recipeRequest
    ) throws Exception {
        return ResponseEntity.ok(projectService.updateRecipe(idRecipe, recipeRequest));
    }
    //Редактирование шага в рецепте
    @PutMapping("/api/kulinare/{idRecipe}/{idStep}}")
    public ResponseEntity<Step> updateStep(
            @PathVariable Long idRecipe,
            @PathVariable Long idStep,
            @RequestBody StepRequest stepRequest
    ) throws Exception {
        return ResponseEntity.ok(projectService.updateStep(idRecipe, idStep, stepRequest));
    }
}
