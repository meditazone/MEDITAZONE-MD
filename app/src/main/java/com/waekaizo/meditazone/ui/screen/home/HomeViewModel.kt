package com.waekaizo.meditazone.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.waekaizo.meditazone.data.MeditazoneRepository
import com.waekaizo.meditazone.data.local.UserModel
import com.waekaizo.meditazone.data.response.ArticleItem
import com.waekaizo.meditazone.data.response.DataItem
import com.waekaizo.meditazone.data.response.QuoteItem
import com.waekaizo.meditazone.model.Quote
import com.waekaizo.meditazone.ui.common.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MeditazoneRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<DataItem>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<DataItem>>>
        get() = _uiState

    private val _listQuote: MutableStateFlow<UiState<List<QuoteItem>>> = MutableStateFlow(UiState.Loading)
    val listQuote: StateFlow<UiState<List<QuoteItem>>>
        get() = _listQuote

    private val _listArticle: MutableStateFlow<UiState<List<ArticleItem>>> = MutableStateFlow(UiState.Loading)
    val listArticle: StateFlow<UiState<List<ArticleItem>>>
        get() = _listArticle

    var isDialogShown by mutableStateOf(false)
        private set

    fun getAllMeditations() {
        viewModelScope.launch {
            repository.getAllMeditations()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect {meditationItem ->
                    _uiState.value = UiState.Success(meditationItem)
                }
        }
    }

    fun getAllQuotes() {
        viewModelScope.launch {
            repository.getAllQuotes()
                .catch {
                    _listQuote.value = UiState.Error(it.message.toString())
                }
                .collect {quoteItem ->
                    _listQuote.value = UiState.Success(quoteItem)
                }
        }
    }

    fun getAllArticle() {
        viewModelScope.launch {
            repository.getAllArticle()
                .catch {
                    _listArticle.value = UiState.Error(it.message.toString())
                }
                .collect {articleItem ->
                    _listArticle.value = UiState.Success(articleItem)
                }
        }
    }

    fun onQuoteClick() {
        isDialogShown = true
    }

    fun onDismissDialog() {
        isDialogShown = false
    }

    fun getSession(): Flow<UserModel> {
        return repository.getSession()
    }
}