package org.sopt.soptseminar_week1.repository

import org.sopt.soptseminar_week1.data.GithubRepositoryInfo
import org.sopt.soptseminar_week1.data.GithubUserInfo

interface HomeDataSource {
    suspend fun getRepositories(id: String): List<GithubRepositoryInfo>
    suspend fun getUserInfo(id: String): GithubUserInfo
}