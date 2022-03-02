package com.roshan.authenticationpractice.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roshan.authenticationpractice.model.AuthenticationMode

@Composable

fun AuthenticationForm(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    email: String?,
    onEmailChanged: (email: String) -> Unit
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        AuthenticationTitle(
            authenticationMode = authenticationMode
        )
        Spacer(modifier = Modifier.height(40.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp), elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                EmailInput(
                    modifier = Modifier.fillMaxWidth(),
                    email = email,
                    onEmailChanged = onEmailChanged
                )

            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun Preview_AuthenticationForm() {
    MaterialTheme {
        AuthenticationForm(
            modifier = Modifier.fillMaxWidth(),
            authenticationMode = AuthenticationMode.SIGN_IN,
            email = "contact@compose.academy",
//            password = "12345678",
//            satisfiedRequirements = listOf(PasswordRequirement.CAPITAL_LETTER),
//            enableAuthentication = true,
            onEmailChanged = { },
//            onPasswordChanged = { },
//            onAuthenticate = { },
//            onToggleMode = { }
        )
    }
}