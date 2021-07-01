package org.sopt.soptseminar_week1.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import org.sopt.soptseminar_week1.api.Result
import org.sopt.soptseminar_week1.api.RetrofitServiceCreator
import org.sopt.soptseminar_week1.data.GithubUserInfo
import org.sopt.soptseminar_week1.repository.UserDataSourceImpl
import org.sopt.soptseminar_week1.utils.safeApiCall

class UserInfoViewModel : ViewModel() {
    private val _followees = MutableLiveData<List<GithubUserInfo>>()
    val followees: LiveData<List<GithubUserInfo>> = _followees

    private val _followers = MutableLiveData<List<GithubUserInfo>>()
    val followers: LiveData<List<GithubUserInfo>> = _followers

    @ExperimentalSerializationApi
    fun getFollowees(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = runCatching {
                UserDataSourceImpl().getFollowees(userName)
            }.getOrElse {
                throw it
            }
            _followees.postValue(result)
        }
    }

    @ExperimentalSerializationApi
    fun getFollowers(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = runCatching {
                UserDataSourceImpl().getFollowers(userName)
            }.getOrElse {
                throw it
            }
            _followers.postValue(result)
        }
    }

}