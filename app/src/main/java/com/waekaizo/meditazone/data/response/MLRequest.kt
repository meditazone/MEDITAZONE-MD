package com.waekaizo.meditazone.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MLRequest {
	@SerializedName("text")
	@Expose
	var text: String? = null
}
