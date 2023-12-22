package com.waekaizo.meditazone.ui.screen.article

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.waekaizo.meditazone.di.Injection
import com.waekaizo.meditazone.ui.ViewModelFactory
import com.waekaizo.meditazone.ui.common.UiState
import com.waekaizo.meditazone.ui.components.ArticleDialog
import com.waekaizo.meditazone.ui.components.QuoteDialog

@Composable
fun ShowArticleDialog(
    articleId: Int,
    navigateBack: () -> Unit,
    viewModel: ArticleViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(LocalContext.current)
        )
    ),
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { article ->
        when(article) {
            is UiState.Loading -> {
                viewModel.getArticleById(articleId)
            }
            is UiState.Success -> {
                val data = article.data

                ArticleDialog(
                    articleId = data.articleID,
                    title = data.title,
                    thumbnail = data.thumbnail,
                    author = data.author,
                    category = data.category,
                    articleUrl = data.articleUrl,
                    onDismiss = {
                        navigateBack()
                    }
                )
            }
            is UiState.Error -> {

            }
        }
    }
}