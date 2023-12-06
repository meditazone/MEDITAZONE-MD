package com.waekaizo.meditazone.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waekaizo.meditazone.ui.screen.login.LoginContent
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme
import com.waekaizo.meditazone.ui.theme.Purple_Button1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldMeditazone(
    textLabel: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        //colors = TextFieldDefaults.textFieldColors(
        //    containerColor = Purple_Button1,
        //  ),
        label = {
            Text(text = textLabel)
        },
        singleLine = true,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    textLabel: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        //colors = TextFieldDefaults.textFieldColors(
        //    containerColor = Purple_Button1,
        //  ),
        label = {
            Text(text = textLabel)
        },
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
private fun EmailTextFieldPreview() {
    MeditazoneTheme {
        TextFieldMeditazone(
            textLabel = "Email",
            value = String(),
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PasswordTextFieldPreview() {
    MeditazoneTheme {
        PasswordTextField(
            textLabel = "Password",
            value = String(),
            onValueChange = {}
        )
    }
}