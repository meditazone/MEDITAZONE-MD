package com.waekaizo.meditazone.ui.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness6
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.di.Injection
import com.waekaizo.meditazone.ui.ViewModelFactory
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme
import com.waekaizo.meditazone.ui.theme.robotoFontFamily
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    )
) {
    val name by remember { mutableStateOf("User") }

    ProfileContent(
        name = name,
        logout = {
            viewModel.logout()
        }
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileContent(
    name: String,
    logout: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 32.dp, horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(id = R.string.menu_profile),
                style = MaterialTheme.typography.headlineLarge,
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Medium
            )
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 30.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.category_bg_loving),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(shape = CircleShape)
                        .shadow(10.dp, shape = CircleShape)
                )
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Fitur ini sedang dalam pengembangan untuk meningkatkan pengalaman pengguna. Terima kasih atas kesabaran Anda.")
                        }
                    },
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .align(Alignment.BottomEnd)
                        .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape)
                        .size(60.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.CameraAlt,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(70.dp)
                    .clickable {
                        coroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Fitur ini sedang dalam pengembangan untuk meningkatkan pengalaman pengguna. Terima kasih atas kesabaran Anda.")
                        }
                    }
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_person),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Column {
                        Text(
                            text = stringResource(id = R.string.name),
                            modifier = Modifier
                                .padding(start = 16.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                        Text(
                            text = name,
                            modifier = Modifier
                                .padding(start = 16.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        )
                    }
                }
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(30.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(70.dp)
                    .clickable {
                        coroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Fitur ini sedang dalam pengembangan untuk meningkatkan pengalaman pengguna. Terima kasih atas kesabaran Anda.")
                        }
                    }
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.favorite_word),
                        modifier = Modifier
                            .padding(start = 16.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(30.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(70.dp)
                    .clickable {
                        coroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Fitur ini sedang dalam pengembangan untuk meningkatkan pengalaman pengguna. Terima kasih atas kesabaran Anda.")
                        }
                    }
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        imageVector = Icons.Default.Brightness6,
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.theme),
                        modifier = Modifier
                            .padding(start = 16.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(30.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(id = R.string.login),
                color = Color.Gray
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable {
                        logout()
                    }
            ) {
                Text(
                    text = stringResource(id = R.string.logout),
                    modifier = Modifier,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color.Red
                )

                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(30.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    MeditazoneTheme {
        ProfileScreen()
    }
}