package org.sopt.soptseminar_week1.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.soptseminar_week1.data.RepositoryListInfo
import org.sopt.soptseminar_week1.databinding.ItemRepositoryListBinding

class RepositoryListAdapter :
    RecyclerView.Adapter<RepositoryListAdapter.RepositoryListViewHolder>() {
    private val repositoryList = mutableListOf<RepositoryListInfo>()

    fun setRepositoryList(newList:List<RepositoryListInfo>) {
        repositoryList.addAll(newList)
    }

    class RepositoryListViewHolder(private val binding: ItemRepositoryListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(repositoryListInfo: RepositoryListInfo) {
            binding.apply {
                textName.text = repositoryListInfo.repositoryName
                textDesc.text = repositoryListInfo.repositoryDesc
                textLang.text = repositoryListInfo.repositoryLang
            }
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