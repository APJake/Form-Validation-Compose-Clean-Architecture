package com.apjake.formvalidationcompose.domain.usecase

import android.util.Patterns

class ValidateEmail {
    fun execute(email:String): ValidationResult{
        if(email.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = "Email can't be blank"
            )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return ValidationResult(
                successful = false,
                errorMessage = "Invalid email address"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}