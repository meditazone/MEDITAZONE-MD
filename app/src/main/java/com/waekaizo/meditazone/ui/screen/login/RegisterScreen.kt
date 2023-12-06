package com.waekaizo.meditazone.ui.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.ui.components.ButtonGradient
import com.waekaizo.meditazone.ui.components.PasswordTextField
import com.waekaizo.meditazone.ui.components.SectionText2
import com.waekaizo.meditazone.ui.components.SectionText3
import com.waekaizo.meditazone.ui.components.TextFieldMeditazone
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun RegisterScreen() {
    RegisterContent()
}

@Composable
fun RegisterContent() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        SectionText2(
            title1 = stringResource(id = R.string.title_register),
            title2 = stringResource(id = R.string.subtitle_register)
        )
        Spacer(modifier = Modifier.height(120.dp))
        TextFieldMeditazone(
            value = name,
            onValueChange = {name = it},
            textLabel = stringResource(id = R.string.name)
        )
        TextFieldMeditazone(
            value = email,
            onValueChange = {email = it},
            textLabel = stringResource(id = R.string.email)
        )
        PasswordTextField(
            value = password,
            onValueChange = {password = it},
            textLabel = stringResource(id = R.string.password)
        )
        PasswordTextField(
            value = passwordConfirm,
            onValueChange = {passwordConfirm = it},
            textLabel = stringResource(id = R.string.confirm_password)
        )
        Spacer(modifier = Modifier.height(50.dp))
        ButtonGradient(
            textButton = stringResource(id = R.string.register),
            onClick = {}
        )
        Spacer(modifier = Modifier.height(70.dp))
        SectionText3(
            title1 = stringResource(id = R.string.ask_account2),
            title2 = stringResource(id = R.string.submit),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPreview() {
    MeditazoneTheme {
        RegisterContent()
    }
}