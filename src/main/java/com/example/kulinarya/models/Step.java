package com.example.kulinarya.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "step")
@Entity
@Getter
@Setter
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_step")
    private Long idStep;
    @ManyToOne
    @Column(name = "id_recipe")
    private Recipe recipe;
    @Column(name = "step_description")
    private String stepDescription;
    @Column(name = "step_order")
    private int stepOrder;
}
