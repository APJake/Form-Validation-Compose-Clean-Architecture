package com.apjake.formvalidationcompose.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.apjake.formvalidationcompose.domain.usecase.ValidateEmail
import com.apjake.formvalidationcompose.domain.usecase.ValidatePassword
import com.apjake.formvalidationcompose.domain.usecase.ValidateRepeatedPassword
import com.apjake.formvalidationcompose.domain.usecase.ValidateTerms

class MainViewModel constructor(
    private val validateEmail: ValidateEmail,
    private val validatePassword: ValidatePassword,
    private val validateRepeatedPassword: ValidateRepeatedPassword,
    private val validateTerms: ValidateTerms,

): ViewModel() {

    var state by mutableStateOf(RegistrationFormState())

    fun onEvent(event: RegistrationFormEvent){
        when(event){
            is RegistrationFormEvent.EmailChanged ->{
                state = state.copy(email = event.email)
            }
            is RegistrationFormEvent.PasswordChanged ->{
                state = state.copy(password = event.password)
            }
            is RegistrationFormEvent.RepeatedPasswordChanged -> {
                state = state.copy(repeatedPassword = event.repeatedPassword)
            }
            is RegistrationFormEvent.AcceptTermsChanged ->{
                state = state.copy(acceptedTerms = event.isAccepted)
            }
            is RegistrationFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)
        val repeatedPasswordResult = validateRepeatedPassword.execute(state.password, state.repeatedPassword)
        val acceptedTermResult = validateTerms.execute(state.acceptedTerms)
    }

}