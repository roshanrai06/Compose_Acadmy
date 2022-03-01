package com.roshan.authenticationpractice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roshan.authenticationpractice.model.AuthenticationEvent
import com.roshan.authenticationpractice.model.AuthenticationMode
import com.roshan.authenticationpractice.model.AuthenticationState
import com.roshan.authenticationpractice.model.PasswordRequirements
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthenticationViewModel : ViewModel() {
    val uiState = MutableStateFlow(AuthenticationState())
    private fun toggleAuthenticationMode() {
        val authenticationMode = uiState.value.authenticationMode
        val newAuthenticationMode = if (authenticationMode == AuthenticationMode.SIGN_IN) {
            AuthenticationMode.SIGN_UP
        } else {
            AuthenticationMode.SIGN_IN
        }
        uiState.value = uiState.value.copy(authenticationMode = newAuthenticationMode)
    }

    fun handleEvent(authenticationEvent: AuthenticationEvent) {
        when (authenticationEvent) {
            is AuthenticationEvent.ToggleAuthenticationMode -> {
                toggleAuthenticationMode()
            }
            is AuthenticationEvent.EmailChanged -> {
                updateEmail(authenticationEvent.emailAddress)
            }
            is AuthenticationEvent.PasswordChanged -> {
                updatePassword(authenticationEvent.password)
            }
            is AuthenticationEvent.Authenticate -> {
                authenticate()
            }
            is AuthenticationEvent.ErrorDismissed -> {
                dismissError()
            }

        }
    }

    private fun updateEmail(newEmail: String) {
        uiState.value = uiState.value.copy(email = newEmail)
    }

    private fun updatePassword(newPassword: String) {
        val satisfiedRequirements = mutableListOf<PasswordRequirements>()
        if (newPassword.length > 7) {
            satisfiedRequirements.add(PasswordRequirements.EIGHT_CHARACTERS)
        }
        if (newPassword.any { it.isUpperCase() }) {
            satisfiedRequirements.add(PasswordRequirements.CAPITAL_LETTER)
        }
        if (newPassword.any { it.isDigit() }) {
            satisfiedRequirements.add(PasswordRequirements.NUMBER)
        }
        uiState.value =
            uiState.value.copy(password = newPassword, satisfiedPasswordRequirements = satisfiedRequirements.toList())
    }

    private fun authenticate() {
        uiState.value = uiState.value.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000L)
            withContext(Dispatchers.Main) {
                uiState.value =
                    uiState.value.copy(isLoading = false, error = "Something went wrong!")
            }
        }
    }

    private fun dismissError() {
        uiState.value = uiState.value.copy(
            error = null
        )
    }
}