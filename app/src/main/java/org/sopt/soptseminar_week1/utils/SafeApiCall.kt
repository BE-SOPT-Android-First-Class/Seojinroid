package org.sopt.soptseminar_week1.utils

import retrofit2.Response
import org.sopt.soptseminar_week1.api.Result

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Result<T> {
    return try {
        val myResp = call.invoke()

        if (myResp.isSuccessful) {
            Result.Success(myResp.body()!!)
        } else {
            Result.Error(myResp.message() ?: "Something goes wrong")
        }

    } catch (e: Exception) {
        Result.Error(e.message ?: "Internet error runs")
    }
}