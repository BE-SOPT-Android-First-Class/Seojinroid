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
import org.sopt.soptseminar_week1.data.GithubRepositoryInfo
import org.sopt.soptseminar_week1.data.GithubUserInfo
import org.sopt.soptseminar_week1.repository.HomeDataSource
import org.sopt.soptseminar_week1.repository.HomeDataSourceImpl
import org.sopt.soptseminar_week1.utils.safeApiCall

class HomeViewModel : ViewModel() {
    private val _userProfile = MutableLiveData<GithubUserInfo>()
    val userProfile: LiveData<GithubUserInfo> = _userProfile

    private val _userRepositories = MutableLiveData<List<GithubRepositoryInfo>>()
    val userRepositories: LiveData<List<GithubRepositoryInfo>> = _userRepositories

    @ExperimentalSerializationApi
    fun getUserProfile(userName: String) {
        viewModelScope.launch {
            val result = runCatching {
                HomeDataSourceImpl().getUserInfo(userName)
            }.getOrElse {
                throw it
            }
            _userProfile.postValue(result)
        }
    }

    @ExperimentalSerializationApi
    fun getUserRepositories(userName: String) {
        viewModelScope.launch {
            val result = runCatching {
                HomeDataSourceImpl().getRepositories(userName)
            }.getOrElse {
                throw it
            }
            _userRepositories.postValue(result)
        }
    }
}