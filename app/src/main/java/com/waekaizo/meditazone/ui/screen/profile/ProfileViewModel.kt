package com.waekaizo.meditazone.ui.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waekaizo.meditazone.data.MeditazoneRepository
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val repository: MeditazoneRepository
) : ViewModel() {

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
}