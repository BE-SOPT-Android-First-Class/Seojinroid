package org.sopt.soptseminar_week1.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import androidx.lifecycle.observe
import kotlinx.coroutines.launch
import org.sopt.soptseminar_week1.R
import org.sopt.soptseminar_week1.base.BaseActivity
import org.sopt.soptseminar_week1.data.GithubRepositoryInfo
import org.sopt.soptseminar_week1.databinding.ActivityHomeBinding
import org.sopt.soptseminar_week1.viewmodel.HomeViewModel


class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private val viewModel: HomeViewModel by viewModels()

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
        viewModel.userRepositories.observe(this) {
            initRecyclerView(it)
        }
        viewModel.userProfile.observe(this) {
            binding.apply {
                textHomeProfileGithubId.text = it.login
                textHomeProfileGithubComment.text = it.bio
                textHomeProfileGithubUsername.text = it.name
            }
            Glide.with(binding.imgHomeProfile.context).load(it.avatar_url)
                .into(binding.imgHomeProfile)
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
        lifecycleScope.launch {
            viewModel.getUserProfile("Seojinseojin")
            viewModel.getUserRepositories("Seojinseojin")
        }
    }

}