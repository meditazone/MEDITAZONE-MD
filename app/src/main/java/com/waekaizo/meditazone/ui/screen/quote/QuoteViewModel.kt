package com.waekaizo.meditazone.ui.screen.quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waekaizo.meditazone.data.MeditazoneRepository
import com.waekaizo.meditazone.data.response.DataItem
import com.waekaizo.meditazone.data.response.QuoteItem
import com.waekaizo.meditazone.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuoteViewModel(
    private val repository: MeditazoneRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<QuoteItem>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<QuoteItem>>
        get() = _uiState

    fun getQuoteById(quoteId: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getQuoteById(quoteId))
        }
    }
}