package com.roshan.homepractice.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

import com.roshan.homepractice.R

@Composable
fun Home(modifier: Modifier = Modifier, orientation: Int) {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    Scaffold(modifier = modifier, topBar = {
        TopAppBar(title = {
            Text(text = "Home")
        })
        Navigation(
            modifier = modifier,
            navController = navController
        )
    }, floatingActionButton = {
        FloatingActionButton(onClick =
        {

        }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(id = R.string.cd_create_item)
            )

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