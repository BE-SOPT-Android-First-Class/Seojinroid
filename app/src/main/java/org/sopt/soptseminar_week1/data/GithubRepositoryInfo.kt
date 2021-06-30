package org.sopt.soptseminar_week1.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubRepositoryInfo(
    @SerialName("id") val id: Int,
    @SerialName("node_id") val node_id: String,
    @SerialName("name") val name: String = "no name",
    @SerialName("full_name") val full_name: String?,
    @SerialName("private") val private: Boolean,
    @SerialName("owner") val owner: GithubUserInfo,
    @SerialName("description") val description: String? = "",
    @SerialName("collaborators_url") val collaborators_url: String,
    @SerialName("watchers_count") val watchers_count: Int,
    @SerialName("language") val language: String? = ""
)