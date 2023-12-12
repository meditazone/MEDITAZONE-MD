package com.waekaizo.meditazone.ui.screen.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.model.FakeMeditationData
import com.waekaizo.meditazone.model.Meditation
import com.waekaizo.meditazone.ui.components.CardCategory
import com.waekaizo.meditazone.ui.components.MeditationItemList
import com.waekaizo.meditazone.ui.components.TopBarCategory
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun CategoryScreen() {
    CategoryContent(
        imageBg = "",
        titleCard = "",
        title2 = "",
        descriptionCard = "",
        meditationItem = FakeMeditationData.meditations
    )
}

@Composable
fun CategoryContent(
    imageBg: String,
    titleCard: String,
    title2: String,
    descriptionCard: String,
    meditationItem: List<Meditation>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.category_bg_loving),
                    contentDescription = stringResource(id = R.string.home_image),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Column {
                    TopBarCategory()
                    Spacer(modifier = Modifier.height(90.dp))

                    Box(
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        CardCategory(
                            titleCard = "Loving-Kindness",
                            title2 = "Meditasi Metta",
                            descriptionCard = "Raih ketenangan melalui Meditasi Metta, solusi penuh kasih untuk mengurangi stres dan depresi. Langkah penuh kasih membuka pintu kebaikan, menciptakan ruang ketenangan batin. Teman setia untuk merangkul kesejahteraan mental dan hidup penuh cinta",
                        )
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(end = 32.dp)
                                .align(Alignment.BottomEnd)
                                .offset(y = 10.dp)
                                .size(50.dp)
                                .shadow(elevation = 10.dp, shape = CircleShape)
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .size(100.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.primary,
                                        shape = CircleShape
                                    )
                                    .padding(8.dp)
                            )
                        }
                    }
                }
            }
        }
        items(meditationItem, key = { it.id }) { meditation ->
            MeditationItemList(
                meditationImage = meditation.meditationImage,
                title = meditation.title,
                duration = meditation.duration
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview() {
    MeditazoneTheme {
        CategoryScreen()
    }
}
