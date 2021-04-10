package org.sopt.soptseminar_week1.utils

import android.util.Log

fun activityLogger (activityName : String, methodName : String) {
    Log.d("로그", "$activityName : $methodName Called")
}