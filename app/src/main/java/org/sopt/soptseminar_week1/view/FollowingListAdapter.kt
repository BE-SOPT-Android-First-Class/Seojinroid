package org.sopt.soptseminar_week1.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.soptseminar_week1.data.GithubUserInfo
import org.sopt.soptseminar_week1.databinding.ItemFollowingListBinding

class FollowingListAdapter(followings: List<GithubUserInfo>) :
    RecyclerView.Adapter<FollowingListAdapter.FollowingUserViewHolder>() {

    private val userList = followings.toList()

    class FollowingUserViewHolder(private val binding: ItemFollowingListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(followingListUserInfo: GithubUserInfo, context: Context) {
            binding.textFollowingListProfile.text = followingListUserInfo.login
            Glide.with(context).load(followingListUserInfo.avatar_url)
                .into(binding.imgFollowingListProfile)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingUserViewHolder {
        val binding =
            ItemFollowingListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowingUserViewHolder(binding)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: FollowingUserViewHolder, position: Int) {
        holder.onBind(userList[position], holder.itemView.context)
    }

}