package com.example.kulinarya.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "recipe")
@Setter
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipe")
    private Long idRecipe;
    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "photo_url")
    private URL photoUrl;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<RecipesIngredients> recipesIngredients = new ArrayList<>();
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Step> steps = new ArrayList<>();

    public Recipe(String title, String description, URL photoUrl) {
        this.title = title;
        this.description = description;
        this.photoUrl = photoUrl;
    }
}
