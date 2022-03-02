package com.roshan.authenticationpractice.ui

import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.roshan.authenticationpractice.R
import com.roshan.authenticationpractice.model.AuthenticationMode

@Composable

fun AuthenticationTitle(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode
) {
    Text(
        modifier = modifier,
        text = stringResource(
            if (authenticationMode == AuthenticationMode.SIGN_IN) {
                R.string.title_sign_in
            } else {
                R.string.title_sign_up
            }
        ), fontSize = 24.sp, fontWeight = FontWeight.Black
    )

}

@Preview(showBackground = true)
@Composable
fun Preview_AuthenticationTitle() {
    MaterialTheme {
        AuthenticationTitle(
            modifier = Modifier.wrapContentWidth(),
            authenticationMode = AuthenticationMode.SIGN_IN
        )
    }
}