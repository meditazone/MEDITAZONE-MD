package com.waekaizo.meditazone.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme
import com.waekaizo.meditazone.ui.theme.Purple_Button1


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldMeditazone(
    textLabel: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next
        ),
        label = {
            Text(text = textLabel)
        },
        singleLine = true,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        keyboardActions = KeyboardActions(
            onNext = {(FocusDirection.Down)}
        ),
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PasswordTextField(
    textLabel: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = textLabel)
        },
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                // Handle registration logic here
            }
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun EmailTextFieldPreview() {
    MeditazoneTheme {
        TextFieldMeditazone(
            textLabel = "Email",
            value = String(),
            onValueChange = {},
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