package com.waekaizo.meditazone.data.response

import com.google.gson.annotations.SerializedName

data class MeditationResponse(

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("message")
	val message: String
)

data class DataItem(

	@field:SerializedName("duration")
	val duration: String,

	@field:SerializedName("thumbnail")
	val thumbnail: String,

	@field:SerializedName("audioURL")
	val audioURL: String,

	@field:SerializedName("backgroundCard")
	val backgroundCard: String,

	@field:SerializedName("meditation_ID")
	val meditationID: Int,

	@field:SerializedName("background_MediaPlayer")
	val backgroundMediaPlayer: String,

	@field:SerializedName("category")
	val category: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("type")
	val type: String
)
