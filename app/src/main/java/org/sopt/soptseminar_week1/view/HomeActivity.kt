package org.sopt.soptseminar_week1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import org.sopt.soptseminar_week1.api.RetrofitServiceCreator
import org.sopt.soptseminar_week1.data.GithubRepositoryInfo
import org.sopt.soptseminar_week1.data.GithubUserInfo
import org.sopt.soptseminar_week1.databinding.ActivityHomeBinding
import org.sopt.soptseminar_week1.utils.activityLogger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

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
        val call: Call<List<GithubRepositoryInfo>> =
            RetrofitServiceCreator.githubService.getRepositories("Seojinseojin")
        call.enqueue(object : Callback<List<GithubRepositoryInfo>> {
            override fun onResponse(
                call: Call<List<GithubRepositoryInfo>>,
                response: Response<List<GithubRepositoryInfo>>
            ) {
                if (response.body() != null) {
                    initRecyclerView(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<GithubRepositoryInfo>>, t: Throwable) {
                Log.d("로그", t.toString())
            }
        })
        val call2: Call<GithubUserInfo> =
            RetrofitServiceCreator.githubService.getUserInfo("Seojinseojin")
        call2.enqueue(object : Callback<GithubUserInfo> {
            override fun onResponse(
                call: Call<GithubUserInfo>,
                response: Response<GithubUserInfo>
            ) {
                if (response.body() != null) {
                    binding.apply {
                        textHomeProfileGithubId.text = requireNotNull(response.body()).login
                        textHomeProfileGithubComment.text = requireNotNull(response.body()).bio
                        textHomeProfileGithubUsername.text = requireNotNull(response.body()).name
                    }
                    Glide.with(binding.imgHomeProfile.context).load(response.body()!!.avatar_url)
                        .into(binding.imgHomeProfile)
                }
            }

            override fun onFailure(call: Call<GithubUserInfo>, t: Throwable) {
                Log.d("로그", t.toString())
            }

        })
    }

    private fun initRecyclerView(repositoryList: List<GithubRepositoryInfo>) {
        val repositoryListAdapter = RepositoryListAdapter(repositoryList)
        binding.recyclerviewRepositoryList.adapter = repositoryListAdapter
        repositoryListAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleGetRequest()
        initLaunchUserInfoActivityButton()
    }

    override fun onStart() {
        super.onStart()
        activityLogger(this.localClassName, "onStart")
    }

    override fun onResume() {
        super.onResume()
        activityLogger(this.localClassName, "onResume")
    }

    override fun onPause() {
        super.onPause()
        activityLogger(this.localClassName, "onPause")
    }

    override fun onStop() {
        super.onStop()
        activityLogger(this.localClassName, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        activityLogger(this.localClassName, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        activityLogger(this.localClassName, "onRestart")
    }
}