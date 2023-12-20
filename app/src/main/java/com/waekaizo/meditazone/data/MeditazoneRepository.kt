package com.waekaizo.meditazone.data

import android.util.Log
import com.waekaizo.meditazone.data.api.ApiService
import com.waekaizo.meditazone.data.api.ApiServiceML
import com.waekaizo.meditazone.data.local.UserModel
import com.waekaizo.meditazone.data.local.UserPreference
import com.waekaizo.meditazone.data.response.ArticleItem
import com.waekaizo.meditazone.data.response.DataItem
import com.waekaizo.meditazone.data.response.LoginResponse
import com.waekaizo.meditazone.data.response.MLRequest
import com.waekaizo.meditazone.data.response.MLResponse
import com.waekaizo.meditazone.data.response.QuoteItem
import com.waekaizo.meditazone.model.CategoryMeditation
import com.waekaizo.meditazone.model.CategoryMeditationData
import com.waekaizo.meditazone.model.FakeMeditationData
import com.waekaizo.meditazone.model.FakeQuoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MeditazoneRepository private constructor(
    private val apiService: ApiService,
    private val userPreference: UserPreference,
    private val apiServiceML: ApiServiceML
){
    private val meditationItem = mutableListOf<DataItem>()
    private val quoteItem = mutableListOf<QuoteItem>()
    private val categoryItem = mutableListOf<CategoryMeditation>()

    init {
        if (meditationItem.isEmpty()) {
            FakeMeditationData.meditations.forEach {
                meditationItem.add(it)
            }
        }
        if (quoteItem.isEmpty()) {
            FakeQuoteData.quotes.forEach {
                quoteItem.add(it)
            }
        }
        if (categoryItem.isEmpty()) {
            CategoryMeditationData.categoryMeditation.forEach {
                categoryItem.add(it)
            }
        }
    }

    suspend fun getAllMeditations(): Flow<List<DataItem>> {
        val response = apiService.getAllMeditation()

        return flowOf(response.data)
    }

    fun getCategoryMeditation(categoryId: Long): CategoryMeditation {
        return categoryItem.first {
            it.id == categoryId
        }
    }

    suspend fun getMeditationByCategory(category: String): Flow<List<DataItem>> {
        val response = apiService.getAllMeditation()

        return flowOf(response.data.filter {
            it.category.contains(category, ignoreCase = true)
        })
    }

    suspend fun getMeditationById(meditationId: Int): DataItem {
        val response = apiService.getAllMeditation()

        return response.data.first {
            it.meditationID == meditationId
        }
    }

    suspend fun getAllQuotes() : Flow<List<QuoteItem>> {
        val response = apiService.getAllQuotes()

        return flowOf(response.data)
    }

    suspend fun getQuoteById(meditationId: Int): QuoteItem {
        val response = apiService.getAllQuotes()
        return response.data.first {
            it.quoteID == meditationId
        }
    }

    suspend fun getAllArticle() : Flow<List<ArticleItem>> {
        val response = apiService.getAllArticle()

        return flowOf(response.data)
    }

    /*suspend fun register(name: String, email: String, password: String, confirmPassword: String): SignUpResponse {
        val request = apiService.register(name, email, password, confirmPassword)
        Log.d("SIGNUP", "signUp: ${request.message}")
        return request
    }*/

    suspend fun login(email: String, password: String): LoginResponse {
        val response = apiService.login(email, password)
        Log.d("SIGNUP", "signUp: ${response.message}")
        val data = UserModel(
            token = response.accessToken,
            isLogin = true
        )
        userPreference.saveSession(data)
        return response
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    suspend fun sendInputML(text: String): MLResponse {

        val response = apiServiceML.sendInputML(text)
        return response
    }

    companion object {
        @Volatile
        private var instance: MeditazoneRepository? = null

        fun getInstance(
            apiService: ApiService,
            userPreference: UserPreference,
            apiServiceML: ApiServiceML
        ): MeditazoneRepository =
            instance ?: synchronized(this) {
                MeditazoneRepository(apiService, userPreference, apiServiceML).apply {
                    instance = this
                }
            }
    }
}