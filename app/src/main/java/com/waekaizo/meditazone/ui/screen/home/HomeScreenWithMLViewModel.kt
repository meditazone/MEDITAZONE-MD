package com.waekaizo.meditazone.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waekaizo.meditazone.data.MeditazoneRepository
import com.waekaizo.meditazone.data.response.ArticleItem
import com.waekaizo.meditazone.data.response.DataItem
import com.waekaizo.meditazone.data.response.QuoteItem
import com.waekaizo.meditazone.ui.common.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeScreenWithMLViewModel(private val repository: MeditazoneRepository) : ViewModel() {

    private val _predictClass: MutableStateFlow<UiState<String>> = MutableStateFlow(UiState.Loading)
    val predictClass: Flow<UiState<String>>
        get() = _predictClass

    private val _meditation: MutableStateFlow<UiState<List<DataItem>>> = MutableStateFlow(UiState.Loading)
    val meditation: StateFlow<UiState<List<DataItem>>>
        get() = _meditation

    private val _article: MutableStateFlow<UiState<List<ArticleItem>>> = MutableStateFlow(UiState.Loading)
    val article: StateFlow<UiState<List<ArticleItem>>>
        get() = _article

    private val _quote: MutableStateFlow<UiState<QuoteItem>> = MutableStateFlow(UiState.Loading)
    val quote: StateFlow<UiState<QuoteItem>>
        get() = _quote

    fun getPredictML() {
        viewModelScope.launch {
            repository.getPredictML()
                .catch {
                    _predictClass.value = UiState.Error(it.message.toString())
                }
                .collect {
                    _predictClass.value = UiState.Success(it)
                }
        }
    }

    fun getMeditationByCategory(category: String) {
        viewModelScope.launch {
            repository.getMeditationByCategory(category)
                .catch {
                    _meditation.value = UiState.Error(it.message.toString())
                }
                .collect {
                    _meditation.value = UiState.Success(it)
                }
        }
    }

    fun getArticleByCategory(category: String) {
        viewModelScope.launch {
            repository.getArticleByCategory(category)
                .catch {
                    _article.value = UiState.Error(it.message.toString())
                }
                .collect {
                    _article.value = UiState.Success(it)
                }
        }
    }

    fun getRandomQuoteById() {
        val range = 35 - 1 + 1
        val randomNumber = (Math.random() * range).toInt() + 1
        viewModelScope.launch {
            _quote.value = UiState.Success(repository.getRandomQuoteById(randomNumber))
        }
    }

    fun clearPredictML() {
        viewModelScope.launch {
            repository.clearPredictMl()
        }
    }
}