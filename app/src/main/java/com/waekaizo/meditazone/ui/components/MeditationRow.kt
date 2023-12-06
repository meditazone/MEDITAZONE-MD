package com.waekaizo.meditazone.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waekaizo.meditazone.model.FakeMeditationData
import com.waekaizo.meditazone.model.Meditation
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun MeditationRow(
    listMeditation: List<Meditation>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMeditation, key = { it.id}) {meditation ->
            MeditationItem(
                title = meditation.title,
                type = meditation.type,
                duration = meditation.duration
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MeditationRowPreview() {
    MeditazoneTheme {
        MeditationRow(
            listMeditation = FakeMeditationData.meditations
        )
    }
}

