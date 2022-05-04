package com.apjake.formvalidationcompose.domain.usecase

data class ValidationResult (
    val successful: Boolean,
    val errorMessage: String? = null
)