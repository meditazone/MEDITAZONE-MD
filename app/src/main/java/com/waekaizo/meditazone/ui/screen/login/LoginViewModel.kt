package com.waekaizo.meditazone.ui.screen.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.waekaizo.meditazone.data.MeditazoneRepository
import com.waekaizo.meditazone.ui.common.RegistrationResult
import retrofit2.HttpException

class LoginViewModel(private val repository: MeditazoneRepository) : ViewModel() {
    private val _loginResult = mutableStateOf<RegistrationResult?>(null)
    val loginResult: State<RegistrationResult?> = _loginResult

    suspend fun login(email: String, password: String) {
        try {
            val response = repository.login(email, password)
            if (response.message == "Login successfully") {
                _loginResult.value = RegistrationResult.Success(response.message)
            } else {
                _loginResult.value = RegistrationResult.Error(response.message)
            }
        } catch (e: HttpException) {
            _loginResult.value = RegistrationResult.Error("Login failed Http Exception : ${e.message}")
        } catch (e: Exception) {
            _loginResult.value = RegistrationResult.Error("Login failed: ${e.message}")
        }
    }
}