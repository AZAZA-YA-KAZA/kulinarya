package com.example.kulinarya.models;

import java.net.URL;

public record RecipeRequest (
        String title,
        String description,
        String photoUrl){
}
