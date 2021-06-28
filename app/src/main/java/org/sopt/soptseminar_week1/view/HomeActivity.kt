package org.sopt.soptseminar_week1.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.sopt.soptseminar_week1.api.RetrofitServiceCreator
import org.sopt.soptseminar_week1.base.BaseActivity
import org.sopt.soptseminar_week1.data.GithubRepositoryInfo
import org.sopt.soptseminar_week1.databinding.ActivityHomeBinding
import org.sopt.soptseminar_week1.utils.safeApiCall
import org.sopt.soptseminar_week1.api.Result


class HomeActivity : BaseActivity<ActivityHomeBinding>({ ActivityHomeBinding.inflate(it) }) {
    private var userInfoActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        Log.d("로그", "Came from userInfo Activity")
    }

    private fun initLaunchUserInfoActivityButton() {
        binding.btnFollowingList.setOnClickListener {
            val intent = Intent(this@HomeActivity, UserInfoActivity::class.java)
            userInfoActivityLauncher.launch(intent)
        }
    }

    private fun handleGetRequest() {
        lifecycleScope.launch {
            async {
                when (val result = safeApiCall {
                    RetrofitServiceCreator.getGithubService().getRepositories("Seojinseojin")
                }) {
                    is Result.Success -> {
                        initRecyclerView(result.data)
                    }
                    is Result.Error -> {
                        Log.d("태그", result.exception)
                    }
                }
            }

            async {
                when (val result = safeApiCall {
                    RetrofitServiceCreator.getGithubService().getUserInfo("Seojinseojin")
                }) {
                    is Result.Success -> {
                        binding.apply {
                            textHomeProfileGithubId.text = requireNotNull(result.data).login
                            textHomeProfileGithubComment.text =
                                requireNotNull(result.data).bio
                            textHomeProfileGithubUsername.text =
                                requireNotNull(result.data).name
                        }
                        @Suppress("IMPLICIT_CAST_TO_ANY")
                        Glide.with(binding.imgHomeProfile.context)
                            .load(result.data.avatar_url)
                            .into(binding.imgHomeProfile)
                    }
                    is Result.Error -> {
                        @Suppress("IMPLICIT_CAST_TO_ANY")
                        Log.d("태그", result.exception)
                    }
                }
            }

        }

    }


    private fun initRecyclerView(repositoryList: List<GithubRepositoryInfo>) {
        val repositoryListAdapter = RepositoryListAdapter(repositoryList)
        binding.recyclerviewRepositoryList.adapter = repositoryListAdapter
        repositoryListAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleGetRequest()
        initLaunchUserInfoActivityButton()
    }

}