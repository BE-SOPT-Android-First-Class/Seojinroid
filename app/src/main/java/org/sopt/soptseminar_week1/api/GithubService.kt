package org.sopt.soptseminar_week1.api

import org.sopt.soptseminar_week1.data.GithubRepositoryInfo
import org.sopt.soptseminar_week1.data.GithubUserInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/users/{username}/repos")
    fun getRepositories(@Path("username") username: String): Call<List<GithubRepositoryInfo>>

    @GET("/users/{username}")
    fun getUserInfo(@Path("username") username: String): Call<GithubUserInfo>

    @GET("/users/{username}/followers")
    fun getFollowerInfo(@Path("username") username: String): Call<List<GithubUserInfo>>

    @GET("/users/{username}/following")
    fun getFolloweeInfo(@Path("username") username: String): Call<List<GithubUserInfo>>
}