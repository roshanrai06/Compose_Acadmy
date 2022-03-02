package com.roshan.authenticationpractice.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.roshan.authenticationpractice.model.AuthenticationEvent
import com.roshan.authenticationpractice.model.AuthenticationState

@Composable

fun AuthenticationContent(
    modifier: Modifier = Modifier,
    authenticationState: AuthenticationState,
    handleEvent: (event: AuthenticationEvent) -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        if (authenticationState.isLoading) {
            CircularProgressIndicator()

        } else {
            AuthenticationForm(modifier = Modifier.fillMaxWidth(),
                authenticationMode = authenticationState.authenticationMode,
                email = authenticationState.email,
                onEmailChanged = { email ->
                    handleEvent(AuthenticationEvent.EmailChanged(email))
                })
        }

    }

}

