package org.sopt.soptseminar_week1.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import org.sopt.soptseminar_week1.api.RetrofitServiceCreator
import org.sopt.soptseminar_week1.base.BaseFragment
import org.sopt.soptseminar_week1.data.GithubUserInfo
import org.sopt.soptseminar_week1.databinding.FragmentFollowingListBinding
import org.sopt.soptseminar_week1.utils.activityLogger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowingListFragment : BaseFragment<FragmentFollowingListBinding>() {

    private fun initRecyclerView(followings: List<GithubUserInfo>) {
        val followingListAdapter = FollowingListAdapter(followings)
        binding.recyclerviewFollowingList.adapter = followingListAdapter
    }

    private fun handleGetRequest() {
        val call: Call<List<GithubUserInfo>> =
            RetrofitServiceCreator.githubService.getFollowerInfo("Seojinseojin")
        call.enqueue(object : Callback<List<GithubUserInfo>> {
            override fun onResponse(
                call: Call<List<GithubUserInfo>>,
                response: Response<List<GithubUserInfo>>
            ) {
                if (response.body() !== null) {
                    initRecyclerView(requireNotNull(response.body()))
                }
            }

            override fun onFailure(call: Call<List<GithubUserInfo>>, t: Throwable) {
                Log.d("로그", t.toString())
            }

        })
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