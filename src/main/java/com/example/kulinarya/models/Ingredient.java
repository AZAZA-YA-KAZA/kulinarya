package com.example.kulinarya.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Table(name = "ingredient")
@Entity
@Getter
@Setter
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredients")
    private Long idIngredients;
    @Column(name = "name", length = 50)
    private String name;

}
