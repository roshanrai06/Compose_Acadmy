package com.roshan.authenticationpractice.ui


import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.roshan.authenticationpractice.R
import com.roshan.authenticationpractice.ui.Tags.TAG_ERROR_ALERT

@Composable
fun AuthenticationErrorDialog(
    modifier: Modifier = Modifier,
    error: String,
    dismissError: () -> Unit
) {
    AlertDialog(
        modifier = modifier.testTag(TAG_ERROR_ALERT),
        onDismissRequest = {
            dismissError()
        },
        confirmButton = {
            TextButton(onClick = {
                dismissError()
            }) {
                Text(text = stringResource(id = R.string.error_action))
            }
        },
        title = {
            Text(text = stringResource(id = R.string.error_title), fontSize = 18.sp)
        },
        text = {
            Text(text = error)
        }
    )
}

@Preview
@Composable
fun Preview_AuthenticationErrorDialog() {
    MaterialTheme {
        AuthenticationErrorDialog(
            error = "There was an error!",
            dismissError = { }
        )
    }
}
