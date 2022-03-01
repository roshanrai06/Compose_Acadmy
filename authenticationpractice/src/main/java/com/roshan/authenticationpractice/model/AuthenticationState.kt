package com.roshan.authenticationpractice.model

data class AuthenticationState(
    val authenticationMode: AuthenticationMode = AuthenticationMode.SIGN_IN,
    val email: String? = null,
    val password: String? = null,
    val satisfiedPasswordRequirements: List<PasswordRequirements> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) {
    fun isFormValid(): Boolean {
        return password?.isNotEmpty() == true &&
            email?.isNotEmpty() == true &&
            (authenticationMode == AuthenticationMode.SIGN_IN)
            || satisfiedPasswordRequirements.containsAll(
            PasswordRequirements.values().toList()
        )
    }
}