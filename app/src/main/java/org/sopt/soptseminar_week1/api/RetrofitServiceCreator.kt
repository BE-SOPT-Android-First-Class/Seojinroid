package org.sopt.soptseminar_week1.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceCreator {
    private const val GITHUB_BASE_URL = "https://api.github.com"
    private const val CHERISH_BASE_URL: String = "http://cherishserver.com"
    private fun getRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .create()
                )
            ).build()
    }

    fun getGithubService(): GithubService =
        getRetrofit(GITHUB_BASE_URL).create(GithubService::class.java)

    fun getUserService(): UserService =
        getRetrofit(CHERISH_BASE_URL).create(UserService::class.java)
}