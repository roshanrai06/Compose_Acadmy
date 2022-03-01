package com.roshan.authenticationpractice.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.roshan.authenticationpractice.model.AuthenticationEvent
import com.roshan.authenticationpractice.model.AuthenticationState

@Composable

fun AuthenticationContent(
    modifier: Modifier = Modifier,
    authenticationState: AuthenticationState,
    handleEvent: (event: AuthenticationEvent) -> Unit
) {

}