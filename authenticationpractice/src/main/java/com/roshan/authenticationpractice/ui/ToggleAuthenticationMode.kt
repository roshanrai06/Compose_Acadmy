package com.roshan.authenticationpractice.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.roshan.authenticationpractice.R
import com.roshan.authenticationpractice.model.AuthenticationMode

@Composable
fun ToggleAuthenticationMode(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    toggleAuthentication: () -> Unit
) {
    Surface(
        modifier = modifier,
        elevation = 8.dp
    ) {
        TextButton(modifier =
        Modifier.background(MaterialTheme.colors.surface),
            onClick = {
                toggleAuthentication()
            }) {
            Text(
                text = stringResource(
                    if (authenticationMode == AuthenticationMode.SIGN_IN) {
                        R.string.action_need_account
                    } else {
                        R.string.action_already_have_account
                    }
                )
            )

        }

    }

}