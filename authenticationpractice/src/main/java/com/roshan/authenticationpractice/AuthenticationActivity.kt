package com.roshan.authenticationpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.roshan.authenticationpractice.ui.Authenticate
import com.roshan.authenticationpractice.ui.theme.PracticalJetpackComposeTheme

class AuthenticationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Authenticate()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PracticalJetpackComposeTheme {
        Authenticate()
    }
}