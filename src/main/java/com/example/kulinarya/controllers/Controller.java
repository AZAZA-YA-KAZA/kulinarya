package com.example.kulinarya.controllers;

import com.example.kulinarya.models.*;
import com.example.kulinarya.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    ProjectService projectService;

    public Controller(ProjectService projectService) {
        this.projectService = projectService;
    }

    //Создание рецепта
    @PostMapping("/api/kulinare/recipe")
    public ResponseEntity<Recipe> createRecipe(
            @RequestBody RecipeRequest recipeRequest
            ){
        return ResponseEntity.ok(projectService.createRecipe(recipeRequest));
    }
    //Создание шага
    @PostMapping("/api/kulinare/{idRecipe}/step")
    public ResponseEntity<Step> createStep(
            @PathVariable Long idRecipe,
            @RequestBody StepRequest stepRequest
            ){
        return ResponseEntity.ok(projectService.createStep(idRecipe, stepRequest));
    }
    //Добавление ингредиента
    @PostMapping("/api/kulinare/{idRecipe}/ingredient")
    public ResponseEntity<Ingredient> addIngredient(
            @PathVariable Long idRecipe,
            @RequestBody String name,
            @RequestBody int count,
            @RequestBody String unit
            ) throws Exception {
        return ResponseEntity.ok(projectService.addIngredient(idRecipe, name, count, unit));
    }

    //Редактирование рецепта
    @PutMapping("/api/kulinare/{idRecipe}")
    public ResponseEntity<Recipe> updateRecipe(
            @PathVariable Long idRecipe,
            @RequestBody RecipeRequest recipeRequest
    ) throws Exception {
        return ResponseEntity.ok(projectService.updateRecipe(idRecipe, recipeRequest));
    }
    //Редактирование шага в рецепте
    @PutMapping("/api/kulinare/{idStep}")
    public ResponseEntity<Step> updateStep(
            @PathVariable Long idStep,
            @RequestBody StepRequest stepRequest
    ) throws Exception {
        return ResponseEntity.ok(projectService.updateStep(idStep, stepRequest));
    }
    //Удаление рецепта
    @DeleteMapping("/api/kulinare/{idRecipe}")
    public ResponseEntity<String> deleteRecipe(
            @PathVariable Long idRecipe
    ) {
        return ResponseEntity.ok(projectService.deleteRecipe(idRecipe));
    }
    //Удаление шага в рецепте
    @DeleteMapping("/api/kulinare/{idStep}")
    public ResponseEntity<String> deleteStep(
            @PathVariable Long idStep
    ) {
        return ResponseEntity.ok(projectService.deleteStep(idStep));
    }
    //Удаление ингредиента в рецепте
    @PutMapping("/api/kulinare/{idRecipe}/{idIngredient}")
    public ResponseEntity<String> deleteIngredient(
            @PathVariable Long idRecipe,
            @PathVariable Long idIngredient
    ) throws Exception {
        return ResponseEntity.ok(projectService.deleteIngredient(idRecipe, idIngredient));
    }

    //выдача рецепта
    @GetMapping("/api/kulinare/{idRecipe}")
    public ResponseEntity<Recipe> getRecipe(
            @PathVariable Long idRecipe
    ) throws Exception {
        return ResponseEntity.ok(projectService.getRecipe(idRecipe));
    }
    //Выдача списка шагов рецепта
    @GetMapping("/api/kulinare/{idRecipe}/step")
    public ResponseEntity<List<Step>> getStep(
            @PathVariable Long idRecipe
    ){
        return ResponseEntity.ok(projectService.getStep(idRecipe));
    }
    //Выдача списка ингредиентов рецепта
    @GetMapping("/api/kulinare/{idRecipe}/ingredient")
    public ResponseEntity<List<Object[]>> getIngredient(
            @PathVariable Long idRecipe
    ) {
        return ResponseEntity.ok(projectService.getIngredient(idRecipe));
    }

}
