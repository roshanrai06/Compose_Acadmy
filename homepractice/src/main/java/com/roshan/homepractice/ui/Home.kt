package com.roshan.homepractice.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.roshan.homepractice.R
import com.roshan.homepractice.model.Destination
import kotlinx.coroutines.launch

@Composable
fun Home(modifier: Modifier = Modifier, orientation: Int) {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry.value?.destination?.route?.let {
                Destination.fromString(
                    it
                )
            } ?: run { Destination.Home }
        }
    }
    val coroutineScope = rememberCoroutineScope()

    val snackbarMessage = stringResource(id = R.string.not_available_yet)
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(title = {
                Text(text = "Home")
            }, actions = {
                if (currentDestination != Destination.Feed) {
                    IconButton(onClick = {
                        coroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(message = snackbarMessage)
                        }

                    }) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = stringResource(
                                id = R.string.cd_more_info
                            )
                        )

                    }
                }
            })

        },
        bottomBar = {
            BottomNavigationBar(
                currentDestination = currentDestination,
                onNavigate = {
                    navController.navigate(it.path) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        },
        floatingActionButton = {
            FloatingActionButton(onClick =
            {

            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.cd_create_item)
                )

            }
        }) {
        Navigation(
            modifier = modifier,
            navController = navController
        )

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