package com.waekaizo.meditazone.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.model.FakeQuoteData
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun QuoteItem(
    quote: String,
    nameMotivator: String,
    backgroundUrl: String,
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
            Image(
                painter = painterResource(id = R.drawable.background_quote),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
            )
            Image(
                painter = painterResource(id = R.drawable.icon_quote),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 40.dp)
                    .align(Alignment.TopStart)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.Center)
                    .padding(bottom = 32.dp, start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = quote,
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    textAlign = TextAlign.Start
                )
                Row{
                    Icon(
                        painter = painterResource(id = R.drawable.icon_line),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(30.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = nameMotivator,
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(top = 8.dp, bottom = 8.dp, end = 8.dp, start = 4.dp),
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuoteItemPreview() {
    MeditazoneTheme {
        QuoteItem(
            quote = "Kamu tidak dapat mengontrol semuanya. Terkadang kamu hanya perlu rileks dan yakin bahwa segala sesuatunya akan berhasil. Lepaskan sedikit dan biarkan hidup berjalan selayaknya air mengalir",
            nameMotivator = "Jon Hamm",
            backgroundUrl = ""
        )
    }
}