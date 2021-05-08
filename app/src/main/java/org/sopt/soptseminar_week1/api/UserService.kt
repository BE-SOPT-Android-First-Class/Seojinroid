package org.sopt.soptseminar_week1.api

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.*


interface SignUpService {
    @POST("/login/signup")
    fun signUp(
        @Body body: RequestSignUp
    ): Call<ResponseSignUp>
}

data class RequestSignUp(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)

data class ResponseSignUp(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: ResponseSignUpData
)

data class ResponseSignUpData(
    @SerializedName("UserId") val userId: String,
    @SerializedName("user_nickname") val userNickname: String,
    @SerializedName("token") val token: String
)

interface SignInService {
    @POST("/login/signin")
    fun signIn(
        @Body body: RequestSignIn
    ): Call<ResponseSignIn>
}

data class RequestSignIn(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("sex") val sex: Int,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("birth") val birth: Date
)

data class ResponseSignIn(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: ResponseSignInData
)

data class ResponseSignInData(
    @SerializedName("nickname") val nickname: String
)