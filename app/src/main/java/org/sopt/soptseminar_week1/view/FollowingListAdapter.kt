package org.sopt.soptseminar_week1.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.soptseminar_week1.data.FollowingListUserInfo
import org.sopt.soptseminar_week1.databinding.ItemFollowingListBinding

class FollowingListAdapter : RecyclerView.Adapter<FollowingListAdapter.FollowingUserViewHolder>() {

    private val userList = mutableListOf<FollowingListUserInfo>()

    fun setUserList(newList : List<FollowingListUserInfo>) {
        userList.addAll(newList)
    }

    class FollowingUserViewHolder(private val binding: ItemFollowingListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(followingListUserInfo: FollowingListUserInfo, context: Context) {
            binding.textFollowingListProfile.text = followingListUserInfo.userName
            Glide.with(context).load(followingListUserInfo.userImageSrc).into(binding.imgFollowingListProfile)
            Log.d("로그", "리사이클러뷰 만들어짐 ${followingListUserInfo.userImageSrc}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingUserViewHolder {
        val binding =
            ItemFollowingListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowingUserViewHolder(binding)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: FollowingUserViewHolder, position: Int) {
        holder.onBind(userList[position], holder.itemView.getContext())
    }

}