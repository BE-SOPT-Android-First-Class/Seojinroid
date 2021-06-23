package org.sopt.soptseminar_week1.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.soptseminar_week1.R
import org.sopt.soptseminar_week1.base.BaseActivity
import org.sopt.soptseminar_week1.databinding.ActivityUserInfoBinding

class UserInfoActivity :
    BaseActivity<ActivityUserInfoBinding>({ ActivityUserInfoBinding.inflate(it) }) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val followingListFragment = FollowingListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_user_info, followingListFragment)
        transaction.commit()
    }
}