package com.waekaizo.meditazone.ui.screen.player

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.waekaizo.meditazone.R
import com.waekaizo.meditazone.di.Injection
import com.waekaizo.meditazone.ui.ViewModelFactory
import com.waekaizo.meditazone.ui.common.UiState
import com.waekaizo.meditazone.ui.components.TopBarCategory
import com.waekaizo.meditazone.ui.theme.MeditazoneTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PlayerScreen(
    meditationId: Int,
    viewModel: PlayerViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(LocalContext.current)
        )
    ),
    navigateBack: () -> Unit
) {


    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getMeditationById(meditationId)
            }
            is UiState.Success -> {
                val data = uiState.data
                val audioUrl = data.audioURL
                val mediaPlayer: MediaPlayer = MediaPlayer().apply {
                    setAudioAttributes(
                        AudioAttributes.Builder()
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            .build()
                    )
                    setDataSource(audioUrl)
                }
                PlayerContent(
                    title = data.title,
                    category = data.category,
                    backgroundImg = data.backgroundMediaPlayer,
                    onBackClick = navigateBack,
                    mediaPlayer = mediaPlayer,
                    viewModel = viewModel
                )
            }
            is UiState.Error -> {

            }
        }
    }
}

@Composable
fun PlayerContent(
    title: String,
    category: String,
    backgroundImg: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    mediaPlayer: MediaPlayer,
    viewModel: PlayerViewModel
) {
    val audioFinish = viewModel.audioFinish.observeAsState()
    val scope = rememberCoroutineScope()
    val audioFlag = remember {
        mutableStateOf(true)
    }
    val currentMinutes = viewModel.currentMinutes.observeAsState()
    mediaPlayer.prepareAsync()
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        AsyncImage(
            model = backgroundImg,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        TopBarCategory(
            modifier = Modifier.padding(top = 16.dp),
            onBackClick = onBackClick
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(vertical = 24.dp)
            )
            Text(
                text = category,
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(bottom = 24.dp)
            )
            Slider(
                value = currentMinutes.value!!.toFloat(),
                onValueChange = {},
                valueRange = 0f..mediaPlayer.duration.toFloat(),
                colors = SliderDefaults.colors(
                    thumbColor = Color.White,
                    activeTrackColor = Color.White
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${currentMinutes.value!!} s",
                    color = Color.White
                )
                Log.d("CURRENT MINUTE", "currentMinute : ${currentMinutes.value!!}")
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "${mediaPlayer.duration}",
                    color = Color.White
                )
            }

            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 40.dp)
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.CenterVertically)
                        .shadow(elevation = 10.dp, shape = CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_tenleft),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(100.dp)
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = CircleShape
                            )
                            .padding(8.dp)
                    )
                }
                IconButton(
                    onClick = {
                        if (audioFlag.value) {
                            mediaPlayer.start()
                            scope.launch {
                                delay(500)
                                viewModel.getMediaDuration(mediaPlayer = mediaPlayer)
                            }
                            audioFlag.value = false
                        } else {
                            audioFlag.value = true
                            mediaPlayer.pause()
                        }},
                    modifier = Modifier
                        .padding(horizontal = 40.dp)
                        .size(50.dp)
                        .shadow(elevation = 10.dp, shape = CircleShape)
                ) {
                    Icon(
                        imageVector =
                        if (audioFinish.value == false) {
                            if (audioFlag.value) {
                                Icons.Default.PlayArrow
                            } else {
                                Icons.Default.Pause
                            }
                        } else {
                            Icons.Default.PlayArrow
                        },
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(100.dp)
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = CircleShape
                            )
                            .padding(8.dp)
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.CenterVertically)
                        .shadow(elevation = 10.dp, shape = CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_tenright),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(100.dp)
                            .background(
                                color = MaterialTheme.colorScheme.primary,
                                shape = CircleShape
                            )
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerScreenPreview() {
    MeditazoneTheme {
        PlayerContent(
            title = "Apcaskcoa",
            category = "Breath Awareness",
            backgroundImg = "",
            onBackClick = { /*TODO*/ },
            mediaPlayer = MediaPlayer(),
            viewModel = viewModel()
        )
    }
}
