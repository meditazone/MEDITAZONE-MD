package com.waekaizo.meditazone.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waekaizo.meditazone.ui.theme.Grey40
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun SectionText(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall.copy(
            fontWeight = FontWeight.Medium
        ),
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun SectionText2(
    title1: String,
    title2: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = title1,
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .padding(top = 16.dp)
        )
        Text(
            text = title2,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .padding(vertical = 8.dp)
        )
    }
}

@Composable
fun SectionText3(
    title1: String,
    title2: String,
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = title1,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextButton(
                onClick = { navigateToLogin() },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = title2,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
fun SectionText4(
    text1: String,
    text2: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = text1,
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .padding(vertical = 8.dp)
        )
        Text(
            text = text2,
            color = Grey40,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier
                .padding(vertical = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SectionText2Preview() {
    MeditazoneTheme {
        SectionText2(title1 = "Selamat Datang!", title2 = "Masuk ke Akun Anda")
    }
}

@Preview(showBackground = true)
@Composable
fun SectionText3Preview() {
    MeditazoneTheme {
        SectionText3(title1 = "Belum punya akun?", title2 = "Daftar", navigateToLogin = {})
    }
}

@Preview(showBackground = true)
@Composable
fun SectionText4Preview() {
    MeditazoneTheme {
        SectionText4(text1 = "Kategori", text2 = "Pilih, Dengarkan dan Temukan Ketenangan")
    }
}