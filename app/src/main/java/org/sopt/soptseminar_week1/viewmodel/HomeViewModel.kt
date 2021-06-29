package org.sopt.soptseminar_week1.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.sopt.soptseminar_week1.api.Result
import org.sopt.soptseminar_week1.api.RetrofitServiceCreator
import org.sopt.soptseminar_week1.data.GithubRepositoryInfo
import org.sopt.soptseminar_week1.data.GithubUserInfo
import org.sopt.soptseminar_week1.utils.safeApiCall

class HomeViewModel : ViewModel() {
    private val _userProfile = MutableLiveData<GithubUserInfo>()
    val userProfile: LiveData<GithubUserInfo> = _userProfile

    private val _userRepositories = MutableLiveData<List<GithubRepositoryInfo>>()
    val userRepositories: LiveData<List<GithubRepositoryInfo>> = _userRepositories

    fun getUserProfile(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = safeApiCall {
                RetrofitServiceCreator.getGithubService().getUserInfo(userName)
            }) {
                is Result.Success -> {
                    _userProfile.postValue(result.data)
                }
                is Result.Error -> {
                    Log.d("태그", result.exception)
                }
            }
        }
    }

    fun getUserRepositories(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = safeApiCall {
                RetrofitServiceCreator.getGithubService().getRepositories(userName)
            }) {
                is Result.Success -> {
                    _userRepositories.postValue(result.data)
                }
                is Result.Error -> {
                    Log.d("태그", result.exception)
                }
            }
        }
    }
}