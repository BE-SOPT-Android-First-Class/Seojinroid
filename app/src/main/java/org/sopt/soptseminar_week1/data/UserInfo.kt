package org.sopt.soptseminar_week1.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestSignIn(
    @SerialName("email") val email: String,
    @SerialName("password") val password: String
)

@Serializable
data class ResponseSignIn(
    @SerialName("success") val success: Boolean,
    @SerialName("message") val message: String,
    @SerialName("data") val data: ResponseSignInData
)

@Serializable
data class ResponseSignInData(
    @SerialName("UserId") val userId: String,
    @SerialName("user_nickname") val userNickname: String,
    @SerialName("token") val token: String
)

@Serializable
data class RequestSignUp(
    @SerialName("email") val email: String,
    @SerialName("password") val password: String,
    @SerialName("sex") val sex: Int,
    @SerialName("nickname") val nickname: String,
    @SerialName("phone") val phone: String,
    @SerialName("birth") val birth: String
)

@Serializable
data class ResponseSignUp(
    @SerialName("success") val success: Boolean,
    @SerialName("message") val message: String,
    @SerialName("data") val data: ResponseSignUpData
)

@Serializable
data class ResponseSignUpData(
    @SerialName("nickname") val nickname: String
)