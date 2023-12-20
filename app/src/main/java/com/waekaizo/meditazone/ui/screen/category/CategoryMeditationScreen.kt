package com.waekaizo.meditazone.ui.screen.category

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.data.response.DataItem
import com.waekaizo.meditazone.di.Injection
import com.waekaizo.meditazone.ui.ViewModelFactory
import com.waekaizo.meditazone.ui.common.UiState
import com.waekaizo.meditazone.ui.components.CardCategory
import com.waekaizo.meditazone.ui.components.MeditationItemList
import com.waekaizo.meditazone.ui.components.TopBarCategory
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun CategoryScreen(
    id: Long,
    navigateBack: () -> Unit,
    viewModel: CategoryViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(LocalContext.current)
        )
    ),
    navigateToPlayer: (Int) -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let {uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getCategoryId(id)
            }

            is UiState.Success -> {
                val data = uiState.data
                viewModel.meditation.collectAsState(initial = UiState.Loading).value.let { meditation ->
                    when(meditation) {
                        is UiState.Loading -> {
                            viewModel.getMeditationByCategory(data.name)
                        }
                        is UiState.Success -> {
                            val meditationData = meditation.data
                            CategoryContent(
                                imageBg = data.backgroundImage,
                                titleCard = data.name,
                                title2 = data.title2,
                                descriptionCard = data.descriptionCard,
                                meditationItem = meditationData,
                                navigateBack = navigateBack,
                                navigateToPlayer = navigateToPlayer
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

@Composable
fun CategoryContent(
    imageBg: String,
    titleCard: String,
    title2: String,
    descriptionCard: String,
    meditationItem: List<DataItem>,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    navigateToPlayer: (Int) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = imageBg,
                    contentDescription = stringResource(id = R.string.home_image),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Column {
                    TopBarCategory(
                        onBackClick = navigateBack
                    )
                    Spacer(modifier = Modifier.height(90.dp))

                    Box(
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        CardCategory(
                            titleCard = titleCard,
                            title2 = title2,
                            descriptionCard = descriptionCard,
                        )
                    }
                }
            }
        }
        items(meditationItem, key = { it.meditationID }) { meditation ->
            MeditationItemList(
                meditationImage = meditation.thumbnail,
                title = meditation.title,
                duration = meditation.duration,
                modifier = Modifier
                    .clickable {
                        navigateToPlayer(meditation.meditationID)
                    }
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview() {
    MeditazoneTheme {
        CategoryScreen(
            id = 1,
            navigateBack = {},
            navigateToPlayer = {}
        )
    }
}
