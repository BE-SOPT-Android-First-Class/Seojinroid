package org.sopt.soptseminar_week1.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubUserInfo(
    @SerialName("login") val login: String,
    @SerialName("id") val id: Int,
    @SerialName("node_id") val node_id: String,
    @SerialName("avatar_url") val avatar_url: String,
    @SerialName("gravatar_id") val gravatar_id: String,
    @SerialName("url") val url: String,
    @SerialName("html_url") val html_url: String,
    @SerialName("followers_url") val followers_url: String,
    @SerialName("following_url") val following_url: String,
    @SerialName("gists_url") val gists_url: String,
    @SerialName("starred_url") val starred_url: String,
    @SerialName("subscriptions_url") val subscriptions_url: String,
    @SerialName("organizations_url") val organizations_url: String,
    @SerialName("repos_url") val repos_url: String,
    @SerialName("events_url") val events_url: String,
    @SerialName("received_events_url") val received_events_url: String,
    @SerialName("type") val type: String,
    @SerialName("site_admin") val site_admin: Boolean,
    @SerialName("name") val name: String? = "no name",
    @SerialName("company") val company: String? = "no company",
    @SerialName("blog") val blog: String? = "no blog",
    @SerialName("location") val location: String? = "no location",
    @SerialName("email") val email: String? = "no email",
    @SerialName("hireable") val hireable: String? = "no hireable",
    @SerialName("bio") val bio: String? = "no bio",
    @SerialName("twitter_username") val twitter_username: String? = "no twitter username",
    @SerialName("public_repos") val public_repos: Int? = 0,
    @SerialName("public_gists") val public_gists: Int? = 0,
    @SerialName("followers") val followers: Int? = 0,
    @SerialName("following") val following: Int? = 0,
    @SerialName("created_at") val created_at: String? = "no created at",
    @SerialName("updated_at") val updated_at: String? = "no updated at"
)
