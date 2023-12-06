package com.waekaizo.meditazone

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.waekaizo.meditazone.ui.components.BottomBar
import com.waekaizo.meditazone.ui.navigation.Screen
import com.waekaizo.meditazone.ui.screen.home.HomeScreen
import com.waekaizo.meditazone.ui.screen.meditation.MeditationScreen
import com.waekaizo.meditazone.ui.screen.profile.ProfileScreen
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeditazoneApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) {innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Meditation.route) {
                MeditationScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun MeditazoneAppPreview() {
    MeditazoneTheme {
        MeditazoneApp()
    }
}