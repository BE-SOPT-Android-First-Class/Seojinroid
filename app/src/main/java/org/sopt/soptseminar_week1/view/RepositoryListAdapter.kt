package org.sopt.soptseminar_week1.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.soptseminar_week1.data.GithubRepositoryInfo
import org.sopt.soptseminar_week1.databinding.ItemRepositoryListBinding

class RepositoryListAdapter(private val repositoryList: List<GithubRepositoryInfo>) :
    RecyclerView.Adapter<RepositoryListAdapter.RepositoryListViewHolder>() {

    class RepositoryListViewHolder(private val binding: ItemRepositoryListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(repositoryInfo: GithubRepositoryInfo) {
            binding.repository = repositoryInfo
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