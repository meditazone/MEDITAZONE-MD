package com.waekaizo.meditazone.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.model.FakeArticleData
import com.waekaizo.meditazone.model.FakeMeditationData
import com.waekaizo.meditazone.model.FakeQuoteData
import com.waekaizo.meditazone.ui.components.ArticleRow
import com.waekaizo.meditazone.ui.components.ArticleSection
import com.waekaizo.meditazone.ui.components.CardHome
import com.waekaizo.meditazone.ui.components.HomeSection
import com.waekaizo.meditazone.ui.components.MeditationRow
import com.waekaizo.meditazone.ui.components.QuoteRow
import com.waekaizo.meditazone.ui.components.QuoteSection
import com.waekaizo.meditazone.ui.theme.Grey
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun HomeScreen() {
    HomeContent()
}

@Composable
fun HomeContent() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.home_image),
                contentDescription = stringResource(id = R.string.home_image),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .padding(start = 16.dp, top = 24.dp, end = 16.dp)
                    .fillMaxWidth(),
            ) {
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = "Selamat Sore, ",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Medium
                        )
                    )
                    Text(
                        text = "Rudy",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Spacer(modifier = Modifier.width(100.dp))
                Row(
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    IconButton(
                        onClick = {  }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_search),
                            contentDescription = null,
                            modifier = Modifier
                                .background(color = Grey, shape = CircleShape)
                                .padding(12.dp)
                                .size(16.dp)
                                .align(Alignment.CenterVertically),
                        )
                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.size(50.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile_picture),
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
            }
            CardHome(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = 100.dp)
            )
        }

        Spacer(modifier = Modifier.height(120.dp))

        HomeSection(
            title = stringResource(id = R.string.title_meditation),
            content = { MeditationRow(listMeditation = FakeMeditationData.meditations)},
            modifier = Modifier.padding(start = 8.dp)
        )
        QuoteSection(
            title = stringResource(id = R.string.quote),
            content = { QuoteRow(listQuote = FakeQuoteData.quotes) },
            modifier = Modifier.padding(start = 8.dp)
        )
        ArticleSection(
            title = stringResource(id = R.string.title_article),
            content = { ArticleRow(listMeditation = FakeArticleData.articles) },
            modifier = Modifier.padding(start = 8.dp)
        )

    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun HomeScreenPreview() {
    MeditazoneTheme {
        HomeContent()
    }
}