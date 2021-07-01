package org.sopt.soptseminar_week1.repository

import org.sopt.soptseminar_week1.data.GithubUserInfo

interface UserDataSource {
    suspend fun getFollowers(id: String): List<GithubUserInfo>
    suspend fun getFollowees(id: String): List<GithubUserInfo>
}
