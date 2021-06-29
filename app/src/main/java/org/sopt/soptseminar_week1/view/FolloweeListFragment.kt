package org.sopt.soptseminar_week1.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import kotlinx.coroutines.launch
import org.sopt.soptseminar_week1.base.BaseFragment
import org.sopt.soptseminar_week1.data.GithubUserInfo
import org.sopt.soptseminar_week1.databinding.FragmentFollowingListBinding
import org.sopt.soptseminar_week1.viewmodel.UserInfoViewModel

class FolloweeListFragment : BaseFragment<FragmentFollowingListBinding>() {

    private val viewModel: UserInfoViewModel by activityViewModels()

    private fun initRecyclerView(followees: List<GithubUserInfo>) {
        val followeeListAdapter = FollowingListAdapter(followees)
        binding.recyclerviewFollowingList.adapter = followeeListAdapter
    }

    private fun handleGetRequest() {
        viewModel.followers.observe(viewLifecycleOwner) {
            initRecyclerView(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleGetRequest()
        lifecycleScope.launch {
            viewModel.getFollowers("Seojinseojin")
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFollowingListBinding {
        return FragmentFollowingListBinding.inflate(inflater, container, false)
    }
}