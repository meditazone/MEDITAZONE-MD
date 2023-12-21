package com.waekaizo.meditazone.ui.screen.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waekaizo.meditazone.data.MeditazoneRepository
import com.waekaizo.meditazone.data.response.ArticleItem
import com.waekaizo.meditazone.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel(
    private val repository: MeditazoneRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<ArticleItem>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<ArticleItem>>
        get() = _uiState

    fun getArticleById(articleId: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getArticleById(articleId))
        }
    }
}