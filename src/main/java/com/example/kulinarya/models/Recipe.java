package com.example.kulinarya.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Table(name = "recipe")
@Entity
@Data
@NoArgsConstructor
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
    private String photoUrl;

    public Recipe(String title, String description, String photoUrl) {
        this.title = title;
        this.description = description;
        this.photoUrl = photoUrl;
    }
}
