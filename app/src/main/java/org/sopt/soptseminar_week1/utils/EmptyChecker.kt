package org.sopt.soptseminar_week1.utils

import android.text.Editable

fun isAllEditTextFilled (list: List<Editable>) : Boolean{
    for(item in list) {
        if(item.isBlank()) {
            return false
        }
    }
    return true
}