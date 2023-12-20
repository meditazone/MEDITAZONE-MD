package com.waekaizo.meditazone.data.api

import com.waekaizo.meditazone.data.response.MLResponse
import retrofit2.http.Field
import retrofit2.http.POST

interface ApiServiceML {

    @POST("predict")
    suspend fun sendInputML(
        @Field("text") text: String
    ): MLResponse
}