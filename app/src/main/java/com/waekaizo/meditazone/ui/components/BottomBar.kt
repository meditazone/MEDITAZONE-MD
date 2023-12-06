package com.waekaizo.meditazone.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.ui.navigation.NavigationItem
import com.waekaizo.meditazone.ui.navigation.Screen

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
    ) {
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = painterResource(id = R.drawable.icon_home),
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_meditation),
                icon = painterResource(id = R.drawable.icon_meditation),
                screen = Screen.Meditation
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_profile),
                icon = painterResource(id = R.drawable.icon_profile),
                screen = Screen.Profile
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = false,
                onClick = {
                          navController.navigate(item.screen.route) {
                              popUpTo(navController.graph.findStartDestination().id) {
                                  saveState = true
                              }
                              restoreState = true
                              launchSingleTop = true
                          }
                },
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title)},
            )
        }
    }
}