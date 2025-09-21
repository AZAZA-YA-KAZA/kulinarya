package com.example.kulinarya.models;

import jakarta.persistence.Column;

public record StepRequest(Recipe recipe, String stepDescription, int stepOrder) {
}
