package com.example.kulinarya.repository;

import com.example.kulinarya.models.RecipesIngredients;
import com.example.kulinarya.models.Step;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.net.URL;
import java.util.List;

public interface StepRepository extends JpaRepository<Step, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Step r SET r.stepDescription = :stepDescription, r.stepOrder = :stepOrder " +
            "WHERE r.idStep = :idStep")
    void updateStepById(@Param("idStep") Long idStep,
                          @Param("stepDescription") String stepDescription,
                          @Param("stepOrder") int stepOrder);
    @Modifying
    @Transactional
    @Query("DELETE FROM Step s WHERE s.idRecipe = :idRecipe " +
            "AND s.idStep = :idStep")
    void deletById(@Param("idRecipe") Long idRecipe,
                          @Param("idStep") Long idStep);

    @Query("SELECT s FROM Step s " +
            "WHERE s.idRecipe = :idRecipe")
    List<Step> getListStepByRecipe(@Param("idRecipe") Long idRecipe);
}
