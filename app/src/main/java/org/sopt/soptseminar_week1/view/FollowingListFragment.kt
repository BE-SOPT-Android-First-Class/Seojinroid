package org.sopt.soptseminar_week1.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.sopt.soptseminar_week1.api.RetrofitServiceCreator
import org.sopt.soptseminar_week1.base.BaseFragment
import org.sopt.soptseminar_week1.data.GithubUserInfo
import org.sopt.soptseminar_week1.databinding.FragmentFollowingListBinding
import org.sopt.soptseminar_week1.utils.safeApiCall
import org.sopt.soptseminar_week1.api.Result

class FollowingListFragment : BaseFragment<FragmentFollowingListBinding>() {

    private fun initRecyclerView(followings: List<GithubUserInfo>) {
        val followingListAdapter = FollowingListAdapter(followings)
        binding.recyclerviewFollowingList.adapter = followingListAdapter
    }

    private fun handleGetRequest() {
        lifecycleScope.launch {
            when (val result = safeApiCall {
                RetrofitServiceCreator.getGithubService().getFollowerInfo("Seojinseojin")
            }) {
                is Result.Success -> {
                    initRecyclerView(result.data)
                }
                is Result.Error -> {
                    Log.d("태그", result.exception)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleGetRequest()
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFollowingListBinding {
        return FragmentFollowingListBinding.inflate(inflater, container, false)
    }

}