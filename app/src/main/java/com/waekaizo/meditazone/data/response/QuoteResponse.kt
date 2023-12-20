package com.waekaizo.meditazone.data.response

import com.google.gson.annotations.SerializedName

data class QuoteResponse(

	@field:SerializedName("data")
	val data: List<QuoteItem>,

	@field:SerializedName("message")
	val message: String
)

data class QuoteItem(

	@field:SerializedName("quote")
	val quote: String,

	@field:SerializedName("author")
	val author: String,

	@field:SerializedName("quote_ID")
	val quoteID: Int,

	@field:SerializedName("imageUrl")
	val imageUrl: String
)
