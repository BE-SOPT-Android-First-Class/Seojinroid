package org.sopt.soptseminar_week1.api

import org.sopt.soptseminar_week1.data.RequestSignIn
import org.sopt.soptseminar_week1.data.RequestSignUp
import org.sopt.soptseminar_week1.data.ResponseSignIn
import org.sopt.soptseminar_week1.data.ResponseSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface UserService {
    @POST("/login/signup")
    fun postSignUp(
        @Body body: RequestSignUp
    ): Call<ResponseSignUp>

    @POST("/login/signin")
    fun postSignIn(
        @Body body: RequestSignIn
    ): Call<ResponseSignIn>
}