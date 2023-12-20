package com.waekaizo.meditazone.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.waekaizo.meditazone.MeditazoneViewModel
import com.waekaizo.meditazone.data.MeditazoneRepository
import com.waekaizo.meditazone.ui.screen.category.CategoryViewModel
import com.waekaizo.meditazone.ui.screen.home.HomeViewModel
import com.waekaizo.meditazone.ui.screen.home.InputMLViewModel
import com.waekaizo.meditazone.ui.screen.login.LoginViewModel
import com.waekaizo.meditazone.ui.screen.login.RegisterViewModel
import com.waekaizo.meditazone.ui.screen.meditation.MeditationViewModel
import com.waekaizo.meditazone.ui.screen.player.PlayerViewModel
import com.waekaizo.meditazone.ui.screen.quote.QuoteViewModel

class ViewModelFactory(private val repository: MeditazoneRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(PlayerViewModel::class.java)) {
            return PlayerViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(MeditationViewModel::class.java)) {
            return MeditationViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            return CategoryViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(MeditazoneViewModel::class.java)) {
            return MeditazoneViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(InputMLViewModel::class.java)) {
            return InputMLViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(QuoteViewModel::class.java)) {
            return QuoteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}