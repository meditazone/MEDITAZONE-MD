package com.waekaizo.meditazone.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.data.response.ArticleItem
import com.waekaizo.meditazone.data.response.DataItem
import com.waekaizo.meditazone.data.response.QuoteItem
import com.waekaizo.meditazone.di.Injection
import com.waekaizo.meditazone.model.FakeArticleData
import com.waekaizo.meditazone.model.FakeMeditationData
import com.waekaizo.meditazone.model.FakeQuoteData
import com.waekaizo.meditazone.ui.ViewModelFactory
import com.waekaizo.meditazone.ui.common.UiState
import com.waekaizo.meditazone.ui.components.ArticleRow
import com.waekaizo.meditazone.ui.components.CardHomeML
import com.waekaizo.meditazone.ui.components.CategorySection
import com.waekaizo.meditazone.ui.components.MeditationRow
import com.waekaizo.meditazone.ui.components.QuoteItem
import com.waekaizo.meditazone.ui.theme.Grey
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun HomeScreenWithML(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenWithMLViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
    navigateToPlayer: (Int) -> Unit,
    navigateToInput: () -> Unit,
    navigateToQuote: (Int) -> Unit,
    navigateToArticle: (Int) -> Unit
) {

    var predictClassMeditation by remember {
        mutableStateOf("")
    }

    var predictClassArticle by remember {
        mutableStateOf("")
    }

    var predictClassCard by remember {
        mutableStateOf("")
    }

    var icon by remember {
        mutableIntStateOf(1)
    }

    viewModel.predictClass.collectAsState(initial = UiState.Loading).value.let {classPredict ->
        when(classPredict) {
            is UiState.Loading -> {
                viewModel.getPredictML()
            }
            is UiState.Success -> {
                val data = classPredict.data

                if (data == "anxiety") {
                    predictClassMeditation = "Breath Awareness"
                    predictClassArticle = "Anxiety"
                    predictClassCard = "Anxiety"
                    icon = R.drawable.emote_stress
                } else if (data == "depression") {
                    predictClassMeditation = "Loving Kindness"
                    predictClassArticle = "Depresi"
                    predictClassCard = "Depresi"
                    icon = R.drawable.emote_stress
                } else if (data == "stress") {
                    predictClassMeditation = "Mindfullness"
                    predictClassArticle = "Stress"
                    predictClassCard = "Stress"
                    icon = R.drawable.emote_stress
                }

                viewModel.meditation.collectAsState(initial = UiState.Loading).value.let { meditation ->
                    when(meditation) {
                        is UiState.Loading -> {
                            viewModel.getMeditationByCategory(predictClassMeditation)
                        }
                        is UiState.Success -> {
                            viewModel.quote.collectAsState(initial = UiState.Loading).value.let { quote ->
                                when(quote) {
                                    is UiState.Loading -> {
                                        viewModel.getRandomQuoteById()
                                    }
                                    is UiState.Success -> {
                                        viewModel.article.collectAsState(initial = UiState.Loading).value.let { article ->
                                            when(article) {
                                                is UiState.Loading -> {
                                                    viewModel.getArticleByCategory(predictClassArticle)
                                                }
                                                is UiState.Success -> {
                                                    HomeContentWithML(
                                                        meditationItem = meditation.data,
                                                        modifier = modifier,
                                                        navigateToPlayer = navigateToPlayer,
                                                        navigateToInput = navigateToInput,
                                                        onQuoteClick = {  },
                                                        quoteItem = quote.data,
                                                        showDialog = true,
                                                        onDismissDialog = {},
                                                        listArticle = article.data,
                                                        navigateToQuote = navigateToQuote,
                                                        navigateToArticleDialog = navigateToArticle,
                                                        classPredictCard = predictClassCard,
                                                        icon = painterResource(id = icon),
                                                        clearPredictButton = {  viewModel.clearPredictML() }
                                                    )
                                                }
                                                is UiState.Error -> {

                                                }
                                            }
                                        }
                                    }
                                    is UiState.Error -> {

                                    }
                                }
                            }
                        }
                        is UiState.Error -> {

                        }
                    }
                }
            }
            is UiState.Error -> {

            }
        }
    }
}

@Composable
fun HomeContentWithML(
    meditationItem: List<DataItem>,
    modifier: Modifier = Modifier,
    navigateToPlayer: (Int) -> Unit,
    navigateToInput: () -> Unit,
    onQuoteClick: () -> Unit,
    quoteItem: QuoteItem,
    showDialog: Boolean,
    onDismissDialog: () -> Unit,
    listArticle: List<ArticleItem>,
    navigateToQuote: (Int) -> Unit,
    navigateToArticleDialog: (Int) -> Unit,
    classPredictCard: String,
    icon: Painter,
    clearPredictButton: () -> Unit
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
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
                        text = "Selamat Sore",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Medium
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
            CardHomeML(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = 100.dp),
                clearClassPredict = clearPredictButton,
                icon = icon,
                classPredict = classPredictCard,
            )
        }

        Spacer(modifier = Modifier.height(120.dp))

        CategorySection(
            text1 = stringResource(id = R.string.title_meditation),
            text2 = stringResource(id = R.string.recommend_meditation),
            content = {
                MeditationRow(
                    listMeditation = meditationItem,
                    navigateToPlayer = navigateToPlayer
                )
            },
            modifier = Modifier.padding(start = 8.dp)
        )
        CategorySection(
            text1 = stringResource(id = R.string.quote),
            text2 = stringResource(id = R.string.recommend_quote),
            content = {
                QuoteItem(
                    quote = quoteItem.quote,
                    nameMotivator = quoteItem.author,
                    backgroundUrl = quoteItem.imageUrl,
                    modifier = Modifier
                        .clickable { navigateToQuote(quoteItem.quoteID) },
                    showDialog = showDialog,
                    onDismissDialog = onDismissDialog
                )
            },
            modifier = Modifier.padding(start = 8.dp)
        )
        CategorySection(
            text1 = stringResource(id = R.string.title_article),
            text2 = stringResource(id = R.string.recommend_article),
            content = {
                ArticleRow(
                    listMeditation = listArticle,
                    showDialog = navigateToArticleDialog
                ) },
            modifier = Modifier.padding(start = 8.dp)
        )

    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun HomeScreenMLPreview() {
    MeditazoneTheme {
        HomeContentWithML(
            meditationItem = FakeMeditationData.meditations,
            navigateToPlayer = {},
            navigateToInput = {},
            onQuoteClick = {  },
            quoteItem = FakeQuoteData.quotes[1],
            showDialog = true,
            onDismissDialog = {},
            listArticle = FakeArticleData.articles,
            navigateToQuote = {},
            navigateToArticleDialog = {},
            classPredictCard = "Stress",
            icon = painterResource(id = R.drawable.emot_smile),
            clearPredictButton = {}
        )
    }
}