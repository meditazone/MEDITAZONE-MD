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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.waekaizo.meditazone.model.Quote
import com.waekaizo.meditazone.ui.ViewModelFactory
import com.waekaizo.meditazone.ui.common.UiState
import com.waekaizo.meditazone.ui.components.ArticleRow
import com.waekaizo.meditazone.ui.components.ArticleSection
import com.waekaizo.meditazone.ui.components.CardHome
import com.waekaizo.meditazone.ui.components.HomeSection
import com.waekaizo.meditazone.ui.components.MeditationRow
import com.waekaizo.meditazone.ui.components.QuoteDialog
import com.waekaizo.meditazone.ui.components.QuoteRow
import com.waekaizo.meditazone.ui.components.QuoteSection
import com.waekaizo.meditazone.ui.theme.Grey
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
    navigateToPlayer: (Int) -> Unit,
    navigateToInput: () -> Unit
) {


    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when(uiState) {
            is UiState.Loading -> {
                viewModel.getAllMeditations()
            }
            is UiState.Success -> {
                viewModel.listQuote.collectAsState(initial = UiState.Loading).value.let { quoteList ->
                    when(quoteList) {
                        is UiState.Loading -> {
                            viewModel.getAllQuotes()
                        }
                        is UiState.Success -> {
                            viewModel.listArticle.collectAsState(initial = UiState.Loading).value.let { articleList ->
                                when(articleList) {
                                    is UiState.Loading -> {
                                        viewModel.getAllArticle()
                                    }
                                    is UiState.Success -> {
                                        HomeContent(
                                            meditationItem = uiState.data,
                                            modifier = modifier,
                                            navigateToPlayer = navigateToPlayer,
                                            navigateToInput = navigateToInput,
                                            onQuoteClick = { viewModel.onQuoteClick() },
                                            quoteItem = quoteList.data,
                                            showDialog = viewModel.isDialogShown,
                                            onDismissDialog = {viewModel.onDismissDialog()},
                                            listArticle = articleList.data
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

@Composable
fun HomeContent(
    meditationItem: List<DataItem>,
    modifier: Modifier = Modifier,
    navigateToPlayer: (Int) -> Unit,
    navigateToInput: () -> Unit,
    onQuoteClick: () -> Unit,
    quoteItem: List<QuoteItem>,
    showDialog: Boolean,
    onDismissDialog: () -> Unit,
    listArticle: List<ArticleItem>
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
                    .offset(y = 100.dp),
                navigateToInput = navigateToInput
            )
        }

        Spacer(modifier = Modifier.height(120.dp))

        HomeSection(
            title = stringResource(id = R.string.title_meditation),
            content = {
                MeditationRow(
                    listMeditation = meditationItem,
                    navigateToPlayer = navigateToPlayer
                )
                      },
            modifier = Modifier.padding(start = 8.dp)
        )
        QuoteSection(
            title = stringResource(id = R.string.quote),
            content = {
                QuoteRow(
                    listQuote = quoteItem,
                    onQuoteClick = onQuoteClick,
                    showDialog = showDialog,
                    onDismissDialog = onDismissDialog
                )
                      },
            modifier = Modifier.padding(start = 8.dp)
        )
        ArticleSection(
            title = stringResource(id = R.string.title_article),
            content = {
                ArticleRow(
                    listMeditation = listArticle
                ) },
            modifier = Modifier.padding(start = 8.dp)
        )

    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
private fun HomeScreenPreview() {
    MeditazoneTheme {
        HomeContent(
            meditationItem = FakeMeditationData.meditations,
            navigateToPlayer = {},
            navigateToInput = {},
            onQuoteClick = {  },
            quoteItem = FakeQuoteData.quotes,
            showDialog = true,
            onDismissDialog = {},
            listArticle = FakeArticleData.articles
        )
    }
}