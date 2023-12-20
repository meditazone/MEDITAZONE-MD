package com.waekaizo.meditazone

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.waekaizo.meditazone.di.Injection
import com.waekaizo.meditazone.ui.ViewModelFactory
import com.waekaizo.meditazone.ui.common.UiState
import com.waekaizo.meditazone.ui.components.BottomBar
import com.waekaizo.meditazone.ui.navigation.Screen
import com.waekaizo.meditazone.ui.screen.category.CategoryScreen
import com.waekaizo.meditazone.ui.screen.home.HomeScreen
import com.waekaizo.meditazone.ui.screen.home.InputMLScreen
import com.waekaizo.meditazone.ui.screen.login.LoginScreen
import com.waekaizo.meditazone.ui.screen.login.RegisterScreen
import com.waekaizo.meditazone.ui.screen.meditation.MeditationScreen
import com.waekaizo.meditazone.ui.screen.player.PlayerScreen
import com.waekaizo.meditazone.ui.screen.profile.ProfileScreen
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun MeditazoneApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: MeditazoneViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    var startDestination by remember { mutableStateOf(Screen.Home.route) }

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.InputMl.route && currentRoute != Screen.Player.route && currentRoute != Screen.Signup.route && currentRoute != Screen.Login.route
                && currentRoute != Screen.Category.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) {innerPadding ->
        viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { session ->
            when(session) {
                is UiState.Loading -> {
                    viewModel.getSession()
                }
                is UiState.Success -> {
                    startDestination = if (!session.data.isLogin) {
                        Screen.Login.route
                    } else {
                        Screen.Home.route
                    }
                }
                is UiState.Error -> {

                }
            }
        }
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToPlayer = {meditationId ->
                        navController.navigate(Screen.Player.createRoute(meditationId))
                    },
                    navigateToInput = {
                        navController.navigate(Screen.InputMl.route)
                    }
                )
            }
            composable(Screen.Meditation.route) {
                MeditationScreen(
                    navigateToCategory = {categoryId ->
                        navController.navigate(Screen.Category.createRoute(categoryId))
                    }
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
                 composable(
                route = Screen.Player.route,
                arguments = listOf(navArgument("meditationId") { type = NavType.IntType}),
            ) {
                val id = it.arguments?.getInt("meditationId") ?: -1
                PlayerScreen(
                    meditationId = id,
                    navigateBack = {
                        navController.navigateUp()
                    },
                )
            }
            composable(
                route = Screen.InputMl.route
            ) {
                InputMLScreen(
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
            composable(
                route = Screen.Category.route,
                arguments = listOf(navArgument("id") {type = NavType.LongType},

                ),
            ) {
                val id = it.arguments?.getLong("id") ?: -1
                CategoryScreen(
                    id = id,
                    navigateBack = {navController.navigateUp()},
                    navigateToPlayer = {meditationId ->
                        navController.navigate(Screen.Player.createRoute(meditationId))
                    }
                )
            }
            composable(route = Screen.Signup.route) {
                RegisterScreen(
                    navigateToLogin = {
                        navController.navigate(Screen.Login.route)
                    }
                )
            }
            composable(
                route = Screen.Login.route
            ) {
                LoginScreen(
                    navigateToSignUp = {
                        navController.navigate(Screen.Signup.route)
                    }
                )
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