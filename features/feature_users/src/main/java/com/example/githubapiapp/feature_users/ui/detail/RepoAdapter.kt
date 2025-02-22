package com.example.githubapiapp.feature_users.ui.detail

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapiapp.feature_users.R
import com.example.githubapiapp.feature_users.data.response.GitHubRepoResponse
import com.example.githubapiapp.feature_users.databinding.RepoItemBinding

class RepoAdapter internal constructor(
    private val context: Context,
    data: List<GitHubRepoResponse>,
) :
    RecyclerView.Adapter<RepoAdapter.HolderItem>() {

    private val repoList: List<GitHubRepoResponse> = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderItem {
        val itemBinding = RepoItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HolderItem(context, itemBinding)
    }


    override fun getItemCount(): Int = repoList.size

    override fun onBindViewHolder(holder: HolderItem, position: Int) {
        val repos = repoList[position]
        holder.bind(repos)
    }

    class HolderItem(
        private val context: Context,
        private val itemBinding: RepoItemBinding,
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(repo: GitHubRepoResponse) {
            with(itemBinding) {
                tvName.text = repo.name
                tvDescription.text = repo.description
                tvGithub.text = repo.github
                tvStar.text = context.getString(R.string.user_stars, repo.stars)
                tvWatcher.text = context.getString(R.string.user_watcher, repo.watcher)
                tvLanguage.text = context.getString(R.string.user_language, repo.language)
            }
        }
    }
}
