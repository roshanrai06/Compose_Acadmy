package com.roshan.authenticationpractice.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roshan.authenticationpractice.AuthenticationViewModel

@Composable
fun Authenticate() {
    val viewModel: AuthenticationViewModel = viewModel()
    MaterialTheme() {
        AuthenticationContent(
            modifier = Modifier.fillMaxWidth(),
            authenticationState = viewModel.uiState.collectAsState().value,
            handleEvent = viewModel::handleEvent
        )

    }
}