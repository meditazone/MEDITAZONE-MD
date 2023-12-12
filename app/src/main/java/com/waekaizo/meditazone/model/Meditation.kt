package com.waekaizo.meditazone.model

data class Meditation(
    val id: String,
    val title: String,
    val duration: String,
    val type: String,
    val photoUrl: String,
    val bannerUrl: String,
    val meditationImage: String
)