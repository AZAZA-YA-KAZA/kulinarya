package com.example.kulinarya.controllers;

import com.example.kulinarya.models.Recipe;
import com.example.kulinarya.models.RecipeRequest;
import com.example.kulinarya.service.Server;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Server server;

    public Controller(Server server) {
        this.server = server;
    }

    @GetMapping("/api/kulinare/recipes/create")
    public ResponseEntity<Recipe> createRecipe(
            @RequestBody RecipeRequest recipeRequest
            ){
        return ResponseEntity.ok(server.createRecipe(recipeRequest));
    }
}
