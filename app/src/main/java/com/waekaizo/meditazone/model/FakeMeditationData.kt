package com.waekaizo.meditazone.model

import com.waekaizo.meditazone.data.response.DataItem


object FakeMeditationData {
    val meditations = listOf(
        DataItem(
            meditationID = 1,
            title = "Loving-Kindness",
            duration = "15 Minute",
            type = "Meditation",
            category = "Loving-Kindness",
            backgroundCard = "https://i.ibb.co/tqvjwx3/meditation-image-bg.png",
            thumbnail = "https://i.ibb.co/Zh3G8fX/player-bg.png",
            backgroundMediaPlayer = "https://i.ibb.co/wwqTCth/meditation-image.png",
            audioURL = ""
        ),
        DataItem(
            meditationID = 2,
            title = "Mindfullness asui",
            duration = "10 Minute",
            type = "Meditation",
            category = "Mindfulness",
            backgroundCard = "https://i.ibb.co/tqvjwx3/meditation-image-bg.png",
            thumbnail = "https://i.ibb.co/Zh3G8fX/player-bg.png",
            backgroundMediaPlayer = "https://i.ibb.co/wwqTCth/meditation-image.png",
            audioURL = ""
        ),
        DataItem(
            meditationID = 3,
            title = "Teknik Pernapasan Air",
            duration = "8 Minute",
            type = "Meditation",
            category = "Breath Awareness",
            backgroundCard = "https://i.ibb.co/tqvjwx3/meditation-image-bg.png",
            thumbnail = "https://i.ibb.co/Zh3G8fX/player-bg.png",
            backgroundMediaPlayer = "https://i.ibb.co/wwqTCth/meditation-image.png",
            audioURL = ""
        ),

    )
}
