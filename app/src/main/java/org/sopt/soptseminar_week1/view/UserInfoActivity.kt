package org.sopt.soptseminar_week1.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.soptseminar_week1.R
import org.sopt.soptseminar_week1.base.BaseActivity
import org.sopt.soptseminar_week1.databinding.ActivityUserInfoBinding

class UserInfoActivity :
    BaseActivity<ActivityUserInfoBinding>(R.layout.activity_user_info) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tabLayout = binding.tabLayout
        val viewpager2 = binding.viewPager2Container
        val tabLayoutTextArray = arrayOf("팔로워", "팔로잉")

        viewpager2.adapter = FollowingListViewPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewpager2) { tab, position ->
            tab.text = tabLayoutTextArray[position]
        }.attach()
    }

    inner class FollowingListViewPagerAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> FollowingListFragment()
                else -> FolloweeListFragment()
            }
        }
    }
}