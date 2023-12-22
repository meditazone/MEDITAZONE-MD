package com.waekaizo.meditazone.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.ui.theme.Grey
import com.waekaizo.meditazone.ui.theme.Grey40
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun MeditationItemList(
    meditationImage: String,
    title: String,
    duration: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row {
            AsyncImage(
                model = meditationImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(shape = RoundedCornerShape(5.dp))
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                )
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_watch),
                        contentDescription = null,
                        tint = Grey40,
                        modifier = Modifier
                            .size(15.dp)
                    )
                    Text(
                        text = duration,
                        fontSize = 12.sp,
                        color = Grey40,
                        modifier = Modifier
                            .padding(start = 4.dp)
                    )
                }
            }
        }
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = null,
            tint = Grey40,
            modifier = Modifier
                .align(Alignment.CenterVertically)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MeditationItemListPreview() {
    MeditazoneTheme {
        MeditationItemList(
            meditationImage = "https://i.ibb.co/wwqTCth/meditation-image.png",
            title = "Meditasi Ketenangan Dalam Diri",
            duration = "10 Menit"
        )
    }
}