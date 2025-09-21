package com.example.kulinarya.models;

import jakarta.persistence.Column;

public record StepRequest(String stepDescription, int stepOrder) {
}
