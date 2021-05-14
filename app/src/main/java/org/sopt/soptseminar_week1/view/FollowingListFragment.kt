package org.sopt.soptseminar_week1.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.soptseminar_week1.api.RetrofitServiceCreator
import org.sopt.soptseminar_week1.data.GithubUserInfo
import org.sopt.soptseminar_week1.databinding.FragmentFollowingListBinding
import org.sopt.soptseminar_week1.utils.activityLogger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowingListFragment : Fragment() {

    lateinit var binding: FragmentFollowingListBinding

    private fun initRecyclerView(followings: List<GithubUserInfo>) {
        val followingListAdapter = FollowingListAdapter(followings)
        binding.apply {
            recyclerviewFollowingList.adapter = followingListAdapter
        }
    }

    private fun handleGetRequest() {
        val call: Call<List<GithubUserInfo>> = RetrofitServiceCreator.githubService.getFollowerInfo("Seojinseojin")
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
        handleGetRequest()
    }

    override fun onPause() {
        super.onPause()
        activityLogger(this.javaClass.name, "onPause")
    }

}