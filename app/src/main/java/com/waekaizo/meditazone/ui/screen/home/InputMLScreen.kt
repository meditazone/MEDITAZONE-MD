package com.waekaizo.meditazone.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme
import com.waekaizo.meditazone.ui.theme.Purple_Button2

@Composable
fun InputMLScreen(

) {
    var inputStory by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        InputMLContent()
        OutlinedTextField(
            value = inputStory,
            onValueChange = {inputStory = it},
            modifier = Modifier
                .fillMaxWidth()
                .height(580.dp)
                .padding(vertical = 16.dp),
            label = {
                Text(text = stringResource(id = R.string.ask_emotion))
            }
        )
        IconButton(
            onClick = { /*TODO*/ },
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Purple_Button2
            ),
            modifier = Modifier
                .align(Alignment.End)
                .padding(16.dp)
                .background(shape = RoundedCornerShape(30.dp), color = Purple_Button2)
                .size(100.dp),
            content = {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(100.dp)
                )
            }
        )
    }
}

@Composable
fun InputMLContent(

) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(
            onClick = {},
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
        InputMLScreen()
    }
}