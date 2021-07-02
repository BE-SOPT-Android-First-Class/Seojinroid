package org.sopt.soptseminar_week1.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import org.sopt.soptseminar_week1.base.BaseFragment
import org.sopt.soptseminar_week1.data.GithubUserInfo
import org.sopt.soptseminar_week1.databinding.FragmentFollowingListBinding
import org.sopt.soptseminar_week1.viewmodel.UserInfoViewModel

class FollowingListFragment : BaseFragment<FragmentFollowingListBinding>() {
    private lateinit var viewModel: UserInfoViewModel

    private fun initRecyclerView(followings: List<GithubUserInfo>) {
        val followingListAdapter = FollowingListAdapter(followings)
        binding.recyclerviewFollowingList.adapter = followingListAdapter
    }

    private fun handleGetRequest() {
        viewModel.followees.observe(viewLifecycleOwner) {
            initRecyclerView(it)
        }
    }

    @ExperimentalSerializationApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UserInfoViewModel::class.java)
        handleGetRequest()
        lifecycleScope.launch {
            viewModel.getFollowees(userName = "Seojinseojin")
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFollowingListBinding {
        return FragmentFollowingListBinding.inflate(inflater, container, false)
    }

}