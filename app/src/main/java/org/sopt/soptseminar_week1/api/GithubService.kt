package org.sopt.soptseminar_week1.api

import org.sopt.soptseminar_week1.data.GithubRepositoryInfo
import org.sopt.soptseminar_week1.data.GithubUserInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{username}/repos")
    suspend fun getRepositories(
        @Path(
            value = "username",
            encoded = true
        ) userName: String
    ): Response<List<GithubRepositoryInfo>>

    @GET("users/{username}")
    suspend fun getUserInfo(
        @Path(
            value = "username",
            encoded = true
        ) userName: String
    ): Response<GithubUserInfo>

    @GET("users/{username}/followers")
    suspend fun getFollowerInfo(
        @Path(
            value = "username",
            encoded = true
        ) userName: String
    ): Response<List<GithubUserInfo>>

    @GET("users/{username}/following")
    suspend fun getFolloweeInfo(
        @Path(
            value = "username",
            encoded = true
        ) userName: String
    ): Response<List<GithubUserInfo>>
}