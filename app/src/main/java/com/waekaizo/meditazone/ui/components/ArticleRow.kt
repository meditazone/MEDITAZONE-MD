package com.waekaizo.meditazone.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waekaizo.meditazone.data.response.ArticleItem
import com.waekaizo.meditazone.model.Article
import com.waekaizo.meditazone.model.FakeArticleData
import com.waekaizo.meditazone.model.FakeMeditationData
import com.waekaizo.meditazone.model.Meditation
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme

@Composable
fun ArticleRow(
    listMeditation: List<ArticleItem>,
    modifier: Modifier = Modifier,
    showDialog: (Int) -> Unit
) {
    val context = LocalContext.current
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMeditation, key = { it.articleID}) {article ->
            ArticleItems(
                articleId = article.articleID,
                title = article.title,
                author = article.author,
                thumbnail = article.thumbnail,
                category = article.category,
                articleUrl = article.articleUrl,
                modifier = Modifier
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(article.articleUrl))
                        context.startActivity(intent)
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleRowPreview() {
    MeditazoneTheme {
        ArticleRow(
            listMeditation = FakeArticleData.articles,
            showDialog = {}
        )
    }
}