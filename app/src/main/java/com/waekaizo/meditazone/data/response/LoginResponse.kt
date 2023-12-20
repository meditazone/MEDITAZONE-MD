package com.waekaizo.meditazone.data.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("access_token")
	val accessToken: String,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("token_type")
	val tokenType: String,

	@field:SerializedName("expires_in")
	val expiresIn: Int
)
