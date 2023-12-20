package com.waekaizo.meditazone.data.api

import androidx.annotation.RawRes
import com.waekaizo.meditazone.data.response.ArticleResponse
import com.waekaizo.meditazone.data.response.LoginResponse
import com.waekaizo.meditazone.data.response.MLResponse
import com.waekaizo.meditazone.data.response.MeditationResponse
import com.waekaizo.meditazone.data.response.QuoteResponse
import com.waekaizo.meditazone.data.response.SignUpResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("auth/signup")
    suspend fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("confirmPassword") confirmPassword: String
    ): SignUpResponse

    @FormUrlEncoded
    @POST("auth/signin")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @GET("v3/meditation")
    suspend fun getAllMeditation(): MeditationResponse

    @GET("v1/quotes")
    suspend fun getAllQuotes(): QuoteResponse

    @GET("v2/article")
    suspend fun getAllArticle(): ArticleResponse
}