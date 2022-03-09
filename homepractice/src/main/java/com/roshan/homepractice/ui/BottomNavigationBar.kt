package com.roshan.homepractice.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.roshan.homepractice.model.Destination

@Composable

fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    onNavigate: (destination: Destination) -> Unit
) {
    BottomNavigation(modifier = modifier) {
        listOf(
            Destination.Feed,
            Destination.Contacts,
            Destination.Calender
        ).forEach { destination ->
            BottomNavigationItem(
                selected = currentDestination.path == destination.path,
                onClick = { onNavigate(destination) },
                icon = {
                    destination.icon?.let { image ->
                        Icon(
                            imageVector = image,
                            contentDescription = destination.path
                        )
                    }
                }, label = { Text(text = destination.title) })

        }
    }

}

@Preview
@Composable
fun Preview_BottomNavigationBar() {
    MaterialTheme {
        BottomNavigationBar(
            modifier = Modifier.fillMaxWidth(),
            currentDestination = Destination.Contacts,
            onNavigate = { }
        )
    }
}

