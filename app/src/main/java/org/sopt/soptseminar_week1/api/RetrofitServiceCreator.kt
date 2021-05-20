package org.sopt.soptseminar_week1.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceCreator {
    private const val GITHUB_BASE_URL = "https://api.github.com"
    private val retrofit_github: Retrofit =
        Retrofit.Builder()
            .baseUrl(GITHUB_BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build()
    val githubService: GithubService = retrofit_github.create(GithubService::class.java)
    private const val CHERISH_BASE_URL: String = "http://cherishserver.com"
    private val retrofit_user: Retrofit =
        Retrofit.Builder()
            .baseUrl(CHERISH_BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build()
    val userService: UserService = retrofit_user.create(UserService::class.java)
}