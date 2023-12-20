package com.waekaizo.meditazone.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waekaizo.meditazone.data.response.DataItem
import com.waekaizo.meditazone.model.CategoryData
import com.waekaizo.meditazone.model.CategoryMeditation
import com.waekaizo.meditazone.model.FakeMeditationData
import com.waekaizo.meditazone.model.Meditation
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun MeditationRow(
    listMeditation: List<DataItem>,
    modifier: Modifier = Modifier,
    navigateToPlayer: (Int) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMeditation, key = { it.meditationID}) {meditation ->
            MeditationItem(
                title = meditation.title,
                type = meditation.type,
                duration = meditation.duration,
                backgroundCard = meditation.backgroundCard,
                modifier = Modifier
                    .clickable {
                        navigateToPlayer(meditation.meditationID)
                    }
            )
        }
    }
}

@Composable
fun CategoryRow(
    listCategory: List<CategoryMeditation>,
    modifier: Modifier = Modifier,
    navigateToCategory: (Long) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listCategory, key = { it.id}) {meditation ->
            MeditationItem(
                title = meditation.name,
                type = "Meditasi",
                duration = "10 Menit",
                backgroundCard = meditation.backgroundCard,
                modifier = Modifier
                    .clickable {
                        navigateToCategory(meditation.id)
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MeditationRowPreview() {
    MeditazoneTheme {
        MeditationRow(
            listMeditation = FakeMeditationData.meditations,
            navigateToPlayer = {}
        )
    }
}

