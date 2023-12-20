package com.waekaizo.meditazone.data.response

import com.google.gson.annotations.SerializedName

data class MLResponse(

	@field:SerializedName("predicted_class")
	val predictedClass: String,

	@field:SerializedName("text")
	val text: String,

	@field:SerializedName("predictions")
	val predictions: List<PredictionsItem>
)

data class PredictionsItem(

	@field:SerializedName("probability")
	val probability: Any,

	@field:SerializedName("class")
	val jsonMemberClass: String
)
