package com.example.kulinarya.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "step")
@Entity
@Data
@NoArgsConstructor
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_step")
    private Long idStep;
    @Column(name = "id_recipe")
    private Long idRecipe;
    @Column(name = "step_description")
    private String stepDescription;
    @Column(name = "step_order")
    private int stepOrder;

    public Step(Long idRecipe, String stepDescription, int stepOrder) {
        this.idRecipe = idRecipe;
        this.stepDescription = stepDescription;
        this.stepOrder = stepOrder;
    }
}
