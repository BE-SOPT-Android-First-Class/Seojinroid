package org.sopt.soptseminar_week1.data

import com.google.gson.annotations.SerializedName

data class GithubRepositoryInfo(
    @SerializedName("id") val id: Int,
    @SerializedName("node_id") val node_id: String,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val full_name: String,
    @SerializedName("private") val private: Boolean,
    @SerializedName("owner") val owner: GithubUserInfo,
    @SerializedName("description") val description: String,
    @SerializedName("collaborators_url") val collaborators_url: String,
    @SerializedName("watchers_count") val watchers_count: Int,
    @SerializedName("language") val language: String
)