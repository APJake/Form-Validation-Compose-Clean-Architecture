package com.apjake.formvalidationcompose.domain.usecase

import android.util.Patterns

class ValidateRepeatedPassword {
    fun execute(password:String, repeatedPassword: String): ValidationResult{
        if(password != repeatedPassword){
            return ValidationResult(
                successful = false,
                errorMessage = "Passwords don't match"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}