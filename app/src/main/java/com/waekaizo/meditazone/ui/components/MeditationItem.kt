package com.waekaizo.meditazone.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.ui.theme.Grey
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun MeditationItem(
    title: String,
    type: String,
    duration: String,
    backgroundCard: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .size(width = 233.dp, height = 322.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            //Need to change to AsyncImage if already create
            AsyncImage(
                model = backgroundCard,
                contentDescription = stringResource(id = R.string.meditation_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize(),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.BottomStart)
                    .padding(bottom = 32.dp, start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    modifier = Modifier
                        .padding(bottom = 8.dp),
                    textAlign = TextAlign.Start
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = type,
                        fontSize = 12.sp,
                        color = Grey,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .padding(end = 16.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.icon_watch),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 25.dp)
                            .size(15.dp),
                        tint = Grey
                    )
                    Text(
                        text = duration,
                        fontSize = 12.sp,
                        color = Grey,
                        modifier = Modifier
                            .padding(start = 4.dp)
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MeditationItemPreview() {
    MeditazoneTheme {
        MeditationItem(
            title = "Seventeen",
            type = "Meditation",
            duration = "15 Minute",
            backgroundCard = ""
        )
    }
}