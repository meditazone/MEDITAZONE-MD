package com.waekaizo.meditazone

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
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
import com.waekaizo.meditazone.ui.screen.article.ShowArticleDialog
import com.waekaizo.meditazone.ui.screen.category.CategoryScreen
import com.waekaizo.meditazone.ui.screen.home.HomeScreen
import com.waekaizo.meditazone.ui.screen.home.HomeScreenWithML
import com.waekaizo.meditazone.ui.screen.home.InputMLScreen
import com.waekaizo.meditazone.ui.screen.login.LoginScreen
import com.waekaizo.meditazone.ui.screen.login.RegisterScreen
import com.waekaizo.meditazone.ui.screen.meditation.MeditationScreen
import com.waekaizo.meditazone.ui.screen.player.PlayerScreen
import com.waekaizo.meditazone.ui.screen.profile.ProfileScreen
import com.waekaizo.meditazone.ui.screen.quote.ShowQuoteDialog
import com.waekaizo.meditazone.ui.screen.splash.MeditazoneSplashScreen
import com.waekaizo.meditazone.ui.screen.success.ShowSuccessDialog
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme
import kotlinx.coroutines.delay

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
    var startDestination by remember { mutableStateOf(Screen.SplashScreen.route) }
    var predictClassValue by remember {
        mutableStateOf("")
    }

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.InputMl.route && currentRoute != Screen.Player.route && currentRoute != Screen.Signup.route && currentRoute != Screen.Login.route
                && currentRoute != Screen.Category.route && currentRoute != Screen.SplashScreen.route) {
                BottomBar(navController, currentRoute)
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
                    LaunchedEffect(key1 = true, block = {
                        delay(2000L)
                    })
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
                viewModel.predictClass.collectAsState(initial = UiState.Loading).value.let { predictClass ->
                    when(predictClass) {
                        is UiState.Loading -> {
                            viewModel.getPredictML()
                        }
                        is UiState.Success -> {
                            predictClassValue = predictClass.data
                        }
                        is UiState.Error -> {

                        }
                    }
                }

                if (predictClassValue != "") {
                    HomeScreenWithML(
                        navigateToPlayer = { meditationId ->
                            navController.navigate(Screen.Player.createRoute(meditationId))
                        },
                        navigateToInput = {
                            navController.navigate(Screen.InputMl.route)
                        },
                        navigateToQuote = {quoteId ->
                            navController.navigate(Screen.Quote.createRoute(quoteId))
                        },
                        navigateToArticle = {articleId ->
                            navController.navigate(Screen.Article.createRoute(articleId))
                        }
                    )
                } else {
                    HomeScreen(
                        navigateToPlayer = {meditationId ->
                            navController.navigate(Screen.Player.createRoute(meditationId))
                        },
                        navigateToInput = {
                            navController.navigate(Screen.InputMl.route)
                        },
                        navigateToQuote = {quoteId ->
                            navController.navigate(Screen.Quote.createRoute(quoteId))
                        },
                        navigateToArticle = {articleId ->
                            navController.navigate(Screen.Article.createRoute(articleId))
                        }
                    )
                }
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
                    },
                    navigateToSuccessDialog = {
                        navController.navigate(Screen.Success.route)
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
            composable(
                route = Screen.Quote.route,
                arguments = listOf(navArgument("quoteId") { type = NavType.IntType}),
            ) {
                val id = it.arguments?.getInt("quoteId") ?: -1

                ShowQuoteDialog(
                    quoteId = id,
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
            composable(
                route = Screen.Success.route
            ) {
                ShowSuccessDialog(
                    navigateBack = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(navController.graph.findStartDestination().id)
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable(
                route = Screen.Article.route,
                arguments = listOf(navArgument("articleId") {type = NavType.IntType})
            ) {
                val id = it.arguments?.getInt("articleId") ?: -1

                ShowArticleDialog(
                    articleId = id,
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
            composable(
                route = Screen.SplashScreen.route
            ) {
                MeditazoneSplashScreen(
                    navController = navController
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