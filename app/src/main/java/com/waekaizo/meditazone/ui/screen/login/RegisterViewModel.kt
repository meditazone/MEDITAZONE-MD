package com.waekaizo.meditazone.ui.screen.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waekaizo.meditazone.data.MeditazoneRepository
import com.waekaizo.meditazone.data.api.ApiConfig
import com.waekaizo.meditazone.ui.common.RegistrationResult
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RegisterViewModel(private val repository: MeditazoneRepository) : ViewModel() {
    private val apiService = ApiConfig.getApiService()

    private val _registerResult = mutableStateOf<RegistrationResult?>(null)
    val registerResult: State<RegistrationResult?> = _registerResult



    suspend fun signUp(name: String, email: String, password: String, confirmPassword: String) {
        try {
            val response = apiService.register(name, email, password, confirmPassword)

            if (response.message != "User registered successfully.") {
                _registerResult.value = RegistrationResult.Success(response.message)
            } else {
                _registerResult.value = RegistrationResult.Error(response.message)
            }
        } catch (e: HttpException) {
            _registerResult.value = RegistrationResult.Error("${e.message} : Password should contains a lowercase, a uppercase character and a digit.")
        } catch (e: Exception) {
            _registerResult.value = RegistrationResult.Error("Registration failed: ${e.message}")
        }
    }

    /*fun signUp(name: String, email: String, password: String, confirmPassword: String) {
        viewModelScope.launch {
            repository.register(name, email, password, confirmPassword)
        }
    }*/
}