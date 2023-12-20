package com.waekaizo.meditazone.data.response

import com.google.gson.annotations.SerializedName

data class ArticleResponse(

	@field:SerializedName("data")
	val data: List<ArticleItem>,

	@field:SerializedName("message")
	val message: String
)

data class ArticleItem(

	@field:SerializedName("article_ID")
	val articleID: Int,

	@field:SerializedName("thumbnail")
	val thumbnail: String,

	@field:SerializedName("author")
	val author: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("category")
	val category: String,

	@field:SerializedName("article_url")
	val articleUrl: String
)
