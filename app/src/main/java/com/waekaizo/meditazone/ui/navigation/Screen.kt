package com.waekaizo.meditazone.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Meditation : Screen("meditation")
    object Profile : Screen("profile")
}
