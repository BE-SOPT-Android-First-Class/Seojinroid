package org.sopt.soptseminar_week1.data

import com.google.gson.annotations.SerializedName

data class RequestSignIn(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)

data class ResponseSignIn(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: ResponseSignInData
)

data class ResponseSignInData(
    @SerializedName("UserId") val userId: String,
    @SerializedName("user_nickname") val userNickname: String,
    @SerializedName("token") val token: String
)

data class RequestSignUp(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("sex") val sex: Int,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("birth") val birth: String
)

data class ResponseSignUp(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: ResponseSignUpData
)

data class ResponseSignUpData(
    @SerializedName("nickname") val nickname: String
)