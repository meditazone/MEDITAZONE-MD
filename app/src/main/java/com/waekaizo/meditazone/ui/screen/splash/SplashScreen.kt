package com.waekaizo.meditazone.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.ui.navigation.Screen
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme
import com.waekaizo.meditazone.ui.theme.Purple_Splash1
import com.waekaizo.meditazone.ui.theme.Purple_Splash2
import com.waekaizo.meditazone.ui.theme.prozaLibreFontFamily
import kotlinx.coroutines.delay

@Composable
fun MeditazoneSplashScreen(
    navController: NavController
) {
    LaunchedEffect(true) {
        delay(8000L)
        navController.navigate(Screen.Home.route)
    }
    val color1 = Brush.verticalGradient(listOf(Purple_Splash1, Purple_Splash2))
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color1)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_meditazone1),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
        )
        Text(
            text = stringResource(id = R.string.meditazone),
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Medium,
                fontFamily = prozaLibreFontFamily
            )
        )
        Text(
            text = stringResource(id = R.string.meditazone_moto),
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = prozaLibreFontFamily
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MeditazoneSplashScreenPreview() {
    MeditazoneTheme {
    }
}