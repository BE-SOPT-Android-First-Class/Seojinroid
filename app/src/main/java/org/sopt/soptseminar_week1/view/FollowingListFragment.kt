package org.sopt.soptseminar_week1.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.soptseminar_week1.data.FollowingListUserInfo
import org.sopt.soptseminar_week1.databinding.FragmentFollowingListBinding
import org.sopt.soptseminar_week1.utils.activityLogger

class FollowingListFragment : Fragment() {

    lateinit var binding: FragmentFollowingListBinding

    private fun initRecyclerView() {
        val followingListAdapter = FollowingListAdapter()
        binding.recyclerviewFollowingList.adapter = followingListAdapter
        followingListAdapter.setUserList(listOf(
            FollowingListUserInfo(userName = "SeojinSeojin"),
            FollowingListUserInfo(userName = "l2hyunwoo"),
            FollowingListUserInfo(userName = "WonJoongLee"),
            FollowingListUserInfo(userName = "todayiswindy")
        ))
        followingListAdapter.notifyDataSetChanged()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowingListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityLogger(this.javaClass.name, "onViewCreated")
        initRecyclerView()
    }

    override fun onPause() {
        super.onPause()
        activityLogger(this.javaClass.name, "onPause")
    }

}