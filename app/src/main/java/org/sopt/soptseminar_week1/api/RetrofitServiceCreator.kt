package org.sopt.soptseminar_week1.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object RetrofitServiceCreator {
    private const val GITHUB_BASE_URL = "https://api.github.com/"
    private const val CHERISH_BASE_URL: String = "http://cherishserver.com/"

    private val contentType = MediaType.get("application/json")

    @ExperimentalSerializationApi
    private fun provideSerializer() =
        Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }.asConverterFactory(contentType)

    @ExperimentalSerializationApi
    private fun getRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                provideSerializer()
            ).build()
    }

    @ExperimentalSerializationApi
    fun getGithubService(): GithubService =
        getRetrofit(GITHUB_BASE_URL).create(GithubService::class.java)

    @ExperimentalSerializationApi
    fun getUserService(): UserService =
        getRetrofit(CHERISH_BASE_URL).create(UserService::class.java)
}