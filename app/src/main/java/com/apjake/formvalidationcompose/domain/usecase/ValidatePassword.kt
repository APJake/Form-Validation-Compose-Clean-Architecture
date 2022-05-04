package com.apjake.formvalidationcompose.domain.usecase

import android.util.Patterns

class ValidatePassword {
    fun execute(password:String): ValidationResult{
        if(password.isBlank() || password.length<8){
            return ValidationResult(
                successful = false,
                errorMessage = "Password length should be at least 8 characters"
            )
        }
        val containsLetterAndDigits = password.any { it.isLetter() }
                && password.any{ it.isDigit() }
        if(!containsLetterAndDigits){
            return ValidationResult(
                successful = false,
                errorMessage = "Password should contain at least 1 character and digit"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}