package org.sopt.soptseminar_week1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.sopt.soptseminar_week1.data.GithubUserInfo

class UserInfoViewModel : ViewModel() {
    private val _followees = MutableLiveData<List<GithubUserInfo>>()
    val followees : LiveData<List<GithubUserInfo>> = _followees

    init {
        viewModelScope.launch {
            async(Dispatchers.IO) {

            }
            async(Dispatchers.IO) {

            }
        }
    }

}