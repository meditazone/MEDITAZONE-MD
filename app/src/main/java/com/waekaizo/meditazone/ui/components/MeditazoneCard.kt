package com.waekaizo.meditazone.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.ui.theme.Grey_Card
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun CardHome (
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .size(width = 353.dp, height = 202.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Grey_Card
        )
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.home_card_title),
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Medium
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = stringResource(id = R.string.home_card_subtitle),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            )
            EmotionDetect(modifier = Modifier.padding(top = 16.dp))
        }
    }
}

@Composable
fun CardMeditation (
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .size(width = 353.dp, height = 131.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(brush = SolidColor(value = Grey_Card), alpha = 0.95F)
    ) {
        Text(
            text = stringResource(id = R.string.meditation_card_title1),
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun CardHomePreview() {
    MeditazoneTheme {
        CardHome()
    }
}

@Preview(showBackground = true)
@Composable
fun CardMeditationPreview() {
    MeditazoneTheme {
        CardMeditation()
    }
}