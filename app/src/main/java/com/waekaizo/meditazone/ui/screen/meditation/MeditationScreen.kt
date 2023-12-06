package com.waekaizo.meditazone.ui.screen.meditation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.model.FakeMeditationData
import com.waekaizo.meditazone.ui.components.CardMeditation
import com.waekaizo.meditazone.ui.components.CategorySection
import com.waekaizo.meditazone.ui.components.MeditationRow
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun MeditationScreen() {
    MeditationContent()
}

@Composable
fun MeditationContent() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Box{
            Image(
                painter = painterResource(id = R.drawable.meditation_background),
                contentDescription = stringResource(id = R.string.home_image),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
            )

            CardMeditation(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = 100.dp)
            )
        }
        Spacer(modifier = Modifier.height(90.dp))

        CategorySection(
            text1 = stringResource(id = R.string.category),
            text2 = stringResource(id = R.string.recomend_text),
            content = { MeditationRow(listMeditation = FakeMeditationData.meditations) },
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MeditationScreenPreview() {
    MeditazoneTheme {
        MeditationScreen()
    }
}

