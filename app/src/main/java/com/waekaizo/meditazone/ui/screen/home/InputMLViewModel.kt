package com.waekaizo.meditazone.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waekaizo.meditazone.data.MeditazoneRepository
import com.waekaizo.meditazone.data.response.MLResponse
import com.waekaizo.meditazone.ui.common.RegistrationResult
import kotlinx.coroutines.launch
import retrofit2.HttpException

class InputMLViewModel(private val repository: MeditazoneRepository) : ViewModel() {

    private val _mlResult = mutableStateOf<MLResponse?>(null)
    val mlResponse: State<MLResponse?> = _mlResult

    private val _apiResponse = mutableStateOf("")
    val apiResponse: State<String> = _apiResponse

    private val _classPredict = mutableStateOf("")
    val classPredict: State<String> = _classPredict

    suspend fun sendInputML(text: String) {
        viewModelScope.launch {
            repository.sendInputML(text)
        }
    }
}