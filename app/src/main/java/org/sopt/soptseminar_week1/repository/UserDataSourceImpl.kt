package org.sopt.soptseminar_week1.repository

import kotlinx.serialization.ExperimentalSerializationApi
import org.sopt.soptseminar_week1.api.RetrofitServiceCreator
import org.sopt.soptseminar_week1.data.GithubUserInfo

class UserDataSourceImpl : UserDataSource {
    @ExperimentalSerializationApi
    override suspend fun getFollowers(id: String): List<GithubUserInfo> =
        RetrofitServiceCreator.getGithubService().getFollowerInfo(id)

    @ExperimentalSerializationApi
    override suspend fun getFollowees(id: String): List<GithubUserInfo> =
        RetrofitServiceCreator.getGithubService().getFolloweeInfo(id)
}