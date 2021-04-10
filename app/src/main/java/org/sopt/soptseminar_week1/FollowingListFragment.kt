package org.sopt.soptseminar_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.soptseminar_week1.databinding.FragmentFollowingListBinding
import org.sopt.soptseminar_week1.utils.activityLogger

class FollowingListFragment : Fragment() {

    lateinit var binding: FragmentFollowingListBinding
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
        val followingListAdapter = FollowingListAdapter()
        binding.recyclerviewFollowingList.adapter = followingListAdapter
        followingListAdapter.userList.addAll(
            listOf(
                FollowingListUserInfo(userImageSrc = "나중에", userName = "Seojinroid"),
                FollowingListUserInfo(userImageSrc = "나중에", userName = "HyunWooRoid"),
                FollowingListUserInfo(userImageSrc = "나중에", userName = "Jiyeonroid"),
                FollowingListUserInfo(userImageSrc = "나중에", userName = "WonJoongRoid")
            )
        )
        followingListAdapter.notifyDataSetChanged()
    }

    override fun onPause() {
        super.onPause()
        activityLogger(this.javaClass.name, "onPause")
    }

}