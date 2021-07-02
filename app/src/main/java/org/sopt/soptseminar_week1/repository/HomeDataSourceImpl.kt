package org.sopt.soptseminar_week1.repository

import kotlinx.serialization.ExperimentalSerializationApi
import org.sopt.soptseminar_week1.api.RetrofitServiceCreator
import org.sopt.soptseminar_week1.data.GithubRepositoryInfo
import org.sopt.soptseminar_week1.data.GithubUserInfo

class HomeDataSourceImpl : HomeDataSource {
    @ExperimentalSerializationApi
    override suspend fun getRepositories(id: String): List<GithubRepositoryInfo> =
        RetrofitServiceCreator.getGithubService().getRepositories(id)

    @ExperimentalSerializationApi
    override suspend fun getUserInfo(id: String): GithubUserInfo =
        RetrofitServiceCreator.getGithubService().getUserInfo(id)

}