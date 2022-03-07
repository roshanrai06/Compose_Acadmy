package com.roshan.homepractice.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Home(modifier: Modifier = Modifier, orientation: Int) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(modifier = modifier, topBar = {
        TopAppBar(title = {
            Text(text = "Home")
        })
    }, floatingActionButton = {
        FloatingActionButton(onClick =
        {
            /*TODO*/
        }) {

        }
    }) {

    }

}

@Preview
@Composable
fun Preview_Home() {
    MaterialTheme {
        Home(
            modifier = Modifier.fillMaxSize(),
            orientation = Configuration.ORIENTATION_LANDSCAPE
        )
    }
}