package org.sopt.soptseminar_week1.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.soptseminar_week1.R
import org.sopt.soptseminar_week1.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val followingListFragment = FollowingListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_user_info, followingListFragment)
        transaction.commit()
    }
}