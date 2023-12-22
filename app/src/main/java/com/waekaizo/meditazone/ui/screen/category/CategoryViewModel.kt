package com.waekaizo.meditazone.ui.screen.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waekaizo.meditazone.data.MeditazoneRepository
import com.waekaizo.meditazone.data.response.DataItem
import com.waekaizo.meditazone.model.CategoryMeditation
import com.waekaizo.meditazone.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CategoryViewModel(private val repository: MeditazoneRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<CategoryMeditation>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<CategoryMeditation>>
        get() = _uiState

    private val _meditation: MutableStateFlow<UiState<List<DataItem>>> = MutableStateFlow(UiState.Loading)
    val meditation: StateFlow<UiState<List<DataItem>>>
        get() = _meditation

    fun getCategoryId(categoryId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getCategoryMeditation(categoryId))
        }
    }

    fun getMeditationByCategory(category: String) {
        viewModelScope.launch {
            repository.getMeditationByCategory(category)
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect {
                    _meditation.value = UiState.Success(it)
                }
        }
    }
}