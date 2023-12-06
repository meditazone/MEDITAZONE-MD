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
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.ui.theme.Grey
import com.waekaizo.meditazone.ui.theme.Grey_Card2
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun ArticleItem(
    title: String,
    type: String,
    duration: String,
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
            Image(
                painter = painterResource(id = R.drawable.image_article_sample),
                contentDescription = stringResource(id = R.string.meditation_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize(),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.BottomStart)
                    .background(color = Grey_Card2)
            ) {
                Text(
                    text = title,
                    modifier = Modifier.padding(16.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_watch),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 16.dp, bottom = 16.dp)
                            .size(15.dp),
                    )
                    Text(
                        text = duration,
                        maxLines = 2,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
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
fun ArticleItemPreview() {
    MeditazoneTheme {
        ArticleItem(
            title = "Apa Itu Meditasi ?",
            type = "Article",
            duration = "15 Minute",
        )
    }
}