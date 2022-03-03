package com.roshan.authenticationpractice.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.roshan.authenticationpractice.R.string

@Composable

fun EmailInput(
    modifier: Modifier = Modifier,
    email: String?,
    onEmailChanged: (email: String) -> Unit,
    onNextClicked: () -> Unit
) {
    TextField(
        modifier = modifier,
        value = email ?: "",
        onValueChange = { onEmailChanged(it) },
        label = {
            Text(
                text =
                stringResource(id = string.label_email_address)
            )
        }, singleLine = true, leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null
            )
        }, keyboardOptions =
        KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ), keyboardActions = KeyboardActions(onNext =
        { onNextClicked() })
    )

}

@Preview(showBackground = true)
@Composable
fun Preview_EmailInput() {
    MaterialTheme {
        EmailInput(
            modifier = Modifier.fillMaxWidth(),
            email = "contact@compose.academy",
            onEmailChanged = { },
            onNextClicked = { }
        )
    }
}