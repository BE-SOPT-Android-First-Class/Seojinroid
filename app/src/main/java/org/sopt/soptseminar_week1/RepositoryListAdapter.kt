package org.sopt.soptseminar_week1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.soptseminar_week1.databinding.ItemRepositoryListBinding

class RepositoryListAdapter :
    RecyclerView.Adapter<RepositoryListAdapter.RepositoryListViewHolder>() {
    val repositoryList = mutableListOf<RepositoryListInfo>()

    class RepositoryListViewHolder(private val binding: ItemRepositoryListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(repositoryListInfo: RepositoryListInfo) {
            binding.textName.text = repositoryListInfo.repositoryName
            binding.textDesc.text = repositoryListInfo.repositoryDesc
            binding.textLang.text = repositoryListInfo.repositoryLang
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryListViewHolder {
        val binding =
            ItemRepositoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryListViewHolder(binding)
    }

    override fun getItemCount(): Int = repositoryList.size

    override fun onBindViewHolder(holder: RepositoryListViewHolder, position: Int) {
        holder.onBind(repositoryList[position])
    }
}