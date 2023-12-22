package com.waekaizo.meditazone.ui.screen.favorite

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.data.response.DataItem
import com.waekaizo.meditazone.model.Category
import com.waekaizo.meditazone.model.CategoryData
import com.waekaizo.meditazone.model.FakeMeditationData
import com.waekaizo.meditazone.model.Meditation
import com.waekaizo.meditazone.ui.components.MeditationItemList
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme
import com.waekaizo.meditazone.ui.theme.robotoFontFamily

@Composable
fun FavoriteScreen(

) {
    FavoriteContent(
        meditationItem = FakeMeditationData.meditations
    )
}

@Composable
fun FavoriteContent(
    meditationItem: List<DataItem>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.your_favorite),
            fontFamily = robotoFontFamily,
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        CategoryTabs(
            categories = CategoryData.typeCategory,
            selectedCategory = CategoryData.typeCategory[0],
            onCategorySelected = {},
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text =  stringResource(id = R.string.favorite_meditation),
            fontFamily = robotoFontFamily,
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            content = {
                items(meditationItem, key = { it.meditationID }) { meditation ->
                    MeditationItemList(
                        meditationImage = meditation.thumbnail,
                        title = meditation.title,
                        duration = meditation.duration
                    )
                }
            }
        )
    }
}

private val emptyTabIndicator: @Composable (List<TabPosition>) -> Unit = {}
@Composable
fun CategoryTabs(
    categories: List<Category>,
    selectedCategory: Category,
    onCategorySelected: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedIndex = categories.indexOfFirst { it == selectedCategory }
    TabRow(
        selectedTabIndex = selectedIndex,
        indicator = emptyTabIndicator,
        divider = {},
        modifier = modifier
    ) {
        categories.forEachIndexed { index, category ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onCategorySelected(category) }
            ) {
                ChoiceChipContent(
                    text = category.name,
                    selected = index == selectedIndex,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 16.dp)
                )
            }
        }
    }
}

@Composable
fun ChoiceChipContent(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        color = when {
            selected -> MaterialTheme.colorScheme.primary
            else -> Color.White
        },
        contentColor = when {
            selected -> Color.White
            else -> Color.Black
        },
        shape = RoundedCornerShape(16.dp),
        modifier = modifier,
        border = when {
            selected -> BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary)
            else -> BorderStroke(width = 1.dp, color = Color.Gray)
        }
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteContentPreview() {
    MeditazoneTheme {
        FavoriteScreen()
    }
}
