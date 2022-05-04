package com.apjake.formvalidationcompose.domain.usecase

import android.util.Patterns

class ValidateTerms {
    fun execute(acceptedTerm: Boolean): ValidationResult{
        if(!acceptedTerm){
            return ValidationResult(
                successful = false,
                errorMessage = "Please accept the terms"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}