package com.waekaizo.meditazone.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

val Context.predictML: DataStore<Preferences> by preferencesDataStore("session")

