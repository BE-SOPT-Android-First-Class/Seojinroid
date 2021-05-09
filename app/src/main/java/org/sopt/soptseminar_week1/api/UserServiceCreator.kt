package org.sopt.soptseminar_week1.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserServiceCreator {
    private const val BASE_URL: String = "http://cherishserver.com"

    private val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
        GsonConverterFactory.create()
    ).build()

    val userService: UserService = retrofit.create(UserService::class.java)
}