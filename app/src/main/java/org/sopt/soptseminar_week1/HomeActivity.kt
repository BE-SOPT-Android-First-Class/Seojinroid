package org.sopt.soptseminar_week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.soptseminar_week1.databinding.ActivityHomeBinding
import org.sopt.soptseminar_week1.utils.activityLogger

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private var userInfoActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        Log.d("로그", "Came from userInfo Activity")
    }

    private fun initButton() {
        binding.btnFollowingList.setOnClickListener {
            val intent = Intent(this@HomeActivity, UserInfoActivity::class.java)
            userInfoActivityLauncher.launch(intent)
        }
    }

    private fun initRecyclerView() {
        val repositoryListAdapter = RepositoryListAdapter()
        binding.recyclerviewRepositoryList.adapter = repositoryListAdapter
        repositoryListAdapter.repositoryList.addAll(
            listOf(
                RepositoryListInfo("레포이름", "레포설명", "레포언어"),
                RepositoryListInfo("레포이름", "레포설명", "레포언어"),
                RepositoryListInfo("레포이름", "레포설명", "레포언어"),
                RepositoryListInfo("레포이름", "레포설명", "레포언어"),
                RepositoryListInfo(
                    "레포이름름름름름름름",
                    "레포설명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명명",
                    "레포언어언어언어언어"
                )
            )
        )
        repositoryListAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButton()
        initRecyclerView()
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