package com.waekaizo.meditazone.di

import android.content.Context
import com.waekaizo.meditazone.data.MeditazoneRepository
import com.waekaizo.meditazone.data.api.ApiConfig
import com.waekaizo.meditazone.data.local.UserPreference
import com.waekaizo.meditazone.data.local.dataStore

object Injection {
    fun provideRepository(context: Context): MeditazoneRepository {
        val apiService = ApiConfig.getApiService()
        val pref = UserPreference.getInstance(context.dataStore)
        return MeditazoneRepository.getInstance(apiService, pref)
    }
}