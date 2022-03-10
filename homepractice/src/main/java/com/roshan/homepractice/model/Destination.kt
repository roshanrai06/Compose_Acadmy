package com.roshan.homepractice.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(
    val path: String,
    val icon: ImageVector? = null,
    val isRootDestination: Boolean = true
) {
    object Home : Destination("home")
    object Feed : Destination("feed", Icons.Default.List)
    object Contacts : Destination("contacts", Icons.Default.Person)
    object Calender : Destination("calendar", Icons.Default.DateRange)
    object Settings : Destination("settings", Icons.Default.Settings)
    object Upgrade : Destination("upgrade", Icons.Default.Star)


    val title = path.replaceFirstChar {
        it.uppercase()
    }

    companion object {
        fun fromString(route: String): Destination {
            return when (route) {
                Feed.path -> Feed
                Calender.path -> Calender
                Contacts.path -> Contacts
                Settings.path -> Settings
                Upgrade.path -> Upgrade
                else -> Home
            }
        }
    }
}
