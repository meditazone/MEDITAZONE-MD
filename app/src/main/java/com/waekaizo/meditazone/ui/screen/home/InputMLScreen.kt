package com.waekaizo.meditazone.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.di.Injection
import com.waekaizo.meditazone.ui.ViewModelFactory
import com.waekaizo.meditazone.ui.components.ButtonGradient
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InputMLScreen(
    navigateBack: () -> Unit,
    viewModel: InputMLViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
    navigateToSuccessDialog: () -> Unit
) {
    var text by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            InputMLContent(
                navigateBack = navigateBack
            )
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                    .padding(vertical = 16.dp),
                label = {
                    Text(text = stringResource(id = R.string.ask_emotion))
                },
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )
            ButtonGradient(
                textButton = stringResource(id = R.string.next),
                onClick = {
                    coroutineScope.launch {
                        if (text != "") {
                            viewModel.sendInputML(text)
                            scaffoldState.snackbarHostState.showSnackbar("Input Sedang Diproses")
                            delay(5000)
                            navigateToSuccessDialog()
                        } else {
                            scaffoldState.snackbarHostState.showSnackbar("Input tidak boleh kosong")
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun InputMLContent(
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(
            onClick = {navigateBack()},
            modifier = Modifier
                .padding(vertical = 32.dp)
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .background(color = Color.Black, shape = CircleShape)
                    .padding(8.dp)
            )
        }
        Text(
            text = "Ceritakan Perasaan Anda Hari ini",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(vertical = 8.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun InputMLScreenPreview() {
    MeditazoneTheme {
        InputMLScreen(
            navigateBack = {},
            navigateToSuccessDialog = {}
        )
    }
}