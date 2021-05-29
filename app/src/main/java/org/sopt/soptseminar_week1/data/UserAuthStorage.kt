package org.sopt.soptseminar_week1.data

import android.content.Context

object UserAuthStorage {
    private const val STORAGE_KEY = "user_auth"
    private const val USER_ID = "id"
    private const val USER_PW = "pw"

    private fun getSharedPreferences(context: Context): android.content.SharedPreferences {
        return context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )
    }

    fun saveUserId(context: Context, id: String) {
        val sharedPreferences = getSharedPreferences(context)
        sharedPreferences.edit()
            .putString(USER_ID, id)
            .apply()
    }

    fun saveUserPw(context: Context, pw: String) {
        val sharedPreferences = getSharedPreferences(context)
        sharedPreferences.edit()
            .putString(USER_PW, pw)
            .apply()
    }

    fun getUserId(context: Context): String {
        val sharedPreferences = getSharedPreferences(context)
        return sharedPreferences.getString(USER_ID, "") ?: ""
    }

    fun getUserPw(context: Context): String {
        val sharedPreferences = getSharedPreferences(context)
        return sharedPreferences.getString(USER_PW, "") ?: ""
    }

}