package com.waekaizo.meditazone.ui.common

sealed class RegistrationResult {
    data class Success(val message: String) : RegistrationResult()
    data class Error(val message: String) : RegistrationResult()
}
