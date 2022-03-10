package com.roshan.homepractice.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.roshan.homepractice.model.Destination

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destination.Feed.path
    ) {
        navigation(
            startDestination = Destination.Feed.path,
            route = Destination.Home.path
        ) {
            composable(Destination.Feed.path) {
                ContentArea(
                    modifier = Modifier.fillMaxWidth(),
                    destination = Destination.Feed
                )
            }
            composable(Destination.Contacts.path) {
                ContentArea(
                    modifier = Modifier.fillMaxWidth(),
                    destination = Destination.Contacts
                )
            }
            composable(Destination.Calender.path) {
                ContentArea(
                    modifier = Modifier.fillMaxWidth(),
                    destination = Destination.Calender
                )
            }
            composable(Destination.Upgrade.path) {
                ContentArea(
                    modifier = Modifier.fillMaxWidth(),
                    destination = Destination.Upgrade
                )
            }
            composable(Destination.Settings.path) {
                ContentArea(
                    modifier = Modifier.fillMaxWidth(),
                    destination = Destination.Settings
                )
            }
        }

    }

}
