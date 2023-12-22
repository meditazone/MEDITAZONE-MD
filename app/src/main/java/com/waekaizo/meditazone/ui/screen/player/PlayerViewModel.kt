package com.waekaizo.meditazone.ui.screen.player

import android.media.MediaPlayer
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waekaizo.meditazone.data.MeditazoneRepository
import com.waekaizo.meditazone.data.response.DataItem
import com.waekaizo.meditazone.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlayerViewModel(
    private val repository: MeditazoneRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<DataItem>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<DataItem>>
        get() = _uiState

    private var currentDuration: CountDownTimer? = null
    private val _currentMinutes = MutableLiveData(0)
    val currentMinutes: LiveData<Int> get() = _currentMinutes
    private val _audioFinish = MutableLiveData(false)
    val audioFinish: LiveData<Boolean> get() = _audioFinish

    fun getMeditationById(meditationId: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getMeditationById(meditationId))
        }
    }

    fun getMediaDuration(mediaPlayer: MediaPlayer) {
        currentDuration = object : CountDownTimer(mediaPlayer.duration.toLong(), 500) {
            override fun onTick(millisUntilFinished: Long) {
                _currentMinutes.value = mediaPlayer.currentPosition
            }

            override fun onFinish() {
                _audioFinish.value = true
                Log.d("TAG", "onFinish: Media Player Finished")
            }

        }
    }
}