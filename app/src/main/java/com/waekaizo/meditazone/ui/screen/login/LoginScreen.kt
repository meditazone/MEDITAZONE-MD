package com.waekaizo.meditazone.ui.screen.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.di.Injection
import com.waekaizo.meditazone.ui.ViewModelFactory
import com.waekaizo.meditazone.ui.common.RegistrationResult
import com.waekaizo.meditazone.ui.components.ButtonGradient
import com.waekaizo.meditazone.ui.components.PasswordTextField
import com.waekaizo.meditazone.ui.components.SectionText2
import com.waekaizo.meditazone.ui.components.SectionText3
import com.waekaizo.meditazone.ui.components.TextFieldMeditazone
import com.waekaizo.meditazone.ui.navigation.Screen
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    navigateToSignUp: () -> Unit,
    viewModel: LoginViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            SectionText2(
                title1 = stringResource(id = R.string.title_login),
                title2 = stringResource(id = R.string.subtitle_login)
            )
            Spacer(modifier = Modifier.height(120.dp))
            TextFieldMeditazone(
                value = email,
                onValueChange = { email = it },
                textLabel = stringResource(id = R.string.email)
            )
            PasswordTextField(
                value = password,
                onValueChange = { password = it },
                textLabel = stringResource(id = R.string.password)
            )
            Spacer(modifier = Modifier.height(50.dp))
            ButtonGradient(
                textButton = stringResource(id = R.string.submit),
                onClick = {
                    coroutineScope.launch {
                        if (email.isNotEmpty() && password.isNotEmpty()) {
                            if (email.contains('@')) {
                                if (password.length > 7) {
                                    viewModel.login(email, password)
                                    viewModel.loginResult.value?.let { result ->
                                        when (result) {
                                            is RegistrationResult.Success -> {
                                                scaffoldState.snackbarHostState.showSnackbar(result.message)
                                            }
                                            is RegistrationResult.Error -> {
                                                scaffoldState.snackbarHostState.showSnackbar(result.message)
                                            }
                                        }
                                    }
                                } else {
                                    scaffoldState.snackbarHostState.showSnackbar("password length must be at least 8 characters long")
                                }
                            } else {
                                scaffoldState.snackbarHostState.showSnackbar("This is not Email")
                            }
                        } else {
                            scaffoldState.snackbarHostState.showSnackbar("Field Can Not Empty")
                        }
                    }
                }
            )
            Spacer(modifier = Modifier.height(230.dp))
            SectionText3(
                title1 = stringResource(id = R.string.ask_account),
                title2 = stringResource(id = R.string.register),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                navigateToLogin = navigateToSignUp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    MeditazoneTheme {
        LoginScreen(
            navigateToSignUp = {}
        )
    }
}
