package com.example.kulinarya.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;

@Table(name = "ingredient")
@Entity
@Data
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredient")
    private Long idIngredient;
    @Column(name = "nam", length = 50)
    private String name;

    public Ingredient(String name) {
        this.name = name;
    }
}
