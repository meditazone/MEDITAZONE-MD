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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.ui.theme.Grey_Card2
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun ArticleItems(
    articleId: Int,
    title: String,
    thumbnail: String,
    author: String,
    category: String,
    articleUrl: String,
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
                model = thumbnail,
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
                    modifier = Modifier.padding(16.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = author,
                    maxLines = 1,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(16.dp),
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleItemPreview() {
    MeditazoneTheme {
        ArticleItems(
            articleId = 1,
            title = "Apa Itu Meditasi ?",
            author = "",
            category = "",
            thumbnail = "",
            articleUrl = ""
        )
    }
}