package com.waekaizo.meditazone

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.waekaizo.meditazone.data.MeditazoneRepository
import com.waekaizo.meditazone.data.local.UserModel
import com.waekaizo.meditazone.data.response.DataItem
import com.waekaizo.meditazone.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MeditazoneViewModel(
    private val repository: MeditazoneRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<UserModel>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<UserModel>>
        get() = _uiState

    fun getSession() {
        viewModelScope.launch {
            repository.getSession()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect {userModel ->
                    _uiState.value = UiState.Success(userModel)
                }
        }
    }
}