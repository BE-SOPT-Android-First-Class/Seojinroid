package org.sopt.soptseminar_week1.api

import org.sopt.soptseminar_week1.data.GithubRepositoryInfo
import org.sopt.soptseminar_week1.data.GithubUserInfo
import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("/users/SeojinSeojin/repos")
    fun getRepositories(): Call<List<GithubRepositoryInfo>>

    @GET("/users/Seojinseojin")
    fun getUserInfo(): Call<GithubUserInfo>

    @GET("/users/SeojinSeojin/followers")
    fun getFollowerInfo(): Call<List<GithubUserInfo>>
}