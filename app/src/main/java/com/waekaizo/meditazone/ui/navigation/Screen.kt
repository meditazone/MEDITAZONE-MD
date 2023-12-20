package com.waekaizo.meditazone.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Meditation : Screen("meditation")
    object Profile : Screen("profile")
    object Player : Screen("home/{meditationId}") {
        fun createRoute(meditationId: Int) = "home/$meditationId"
    }
    object InputMl : Screen("home/input")
    object Category : Screen("meditation/{id}") {
        fun createRoute(id: Long) = "meditation/$id"
    }
    object Signup : Screen("signup")
    object Login : Screen("login")
    object Quote : Screen("home/quote/{quoteId}") {
        fun createRoute(quoteId: Int) = "home/quote/$quoteId"
    }
}
