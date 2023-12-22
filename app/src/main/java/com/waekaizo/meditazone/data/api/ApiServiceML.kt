package com.waekaizo.meditazone.data.api

import com.waekaizo.meditazone.data.response.MLResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiServiceML {

    @FormUrlEncoded
    @POST("predict")
    suspend fun sendInputML(
        @Field("text") text: String
    ): MLResponse
}