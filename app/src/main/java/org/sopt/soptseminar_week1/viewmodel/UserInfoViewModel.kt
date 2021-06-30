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
import org.sopt.soptseminar_week1.utils.safeApiCall

class UserInfoViewModel : ViewModel() {
    private val _followees = MutableLiveData<List<GithubUserInfo>>()
    val followees: LiveData<List<GithubUserInfo>> = _followees

    private val _followers = MutableLiveData<List<GithubUserInfo>>()
    val followers: LiveData<List<GithubUserInfo>> = _followers

    @ExperimentalSerializationApi
    fun getFollowees(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = safeApiCall {
                RetrofitServiceCreator.getGithubService().getFolloweeInfo(userName = userName)
            }) {
                is Result.Success -> {
                    _followees.postValue(result.data)
                }
                is Result.Error -> {
                    Log.d("태그", result.exception)
                }
            }
        }
    }

    @ExperimentalSerializationApi
    fun getFollowers(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = safeApiCall {
                RetrofitServiceCreator.getGithubService().getFollowerInfo(userName = userName)
            }) {
                is Result.Success -> {
                    _followers.postValue(result.data)
                }
                is Result.Error -> {
                    Log.d("태그", result.exception)
                }
            }
        }
    }

}