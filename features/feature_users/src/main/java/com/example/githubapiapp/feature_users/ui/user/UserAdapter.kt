package com.example.githubapiapp.feature_users.ui.user

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubapiapp.feature_users.data.response.GitHubUserResponse
import com.example.githubapiapp.feature_users.databinding.UserItemBinding

class UserAdapter internal constructor(
    private val context: Context,
    data: ArrayList<GitHubUserResponse>,
    private val listener: (String) -> Unit,
) :
    RecyclerView.Adapter<UserAdapter.HolderItem>() {

    private val userList: List<GitHubUserResponse> = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderItem {
        val itemBinding = UserItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HolderItem(context, itemBinding, listener)
    }


    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: HolderItem, position: Int) {
        val users = userList[position]
        holder.bind(users)
    }

    class HolderItem(
        private val context: Context,
        private val itemBinding: UserItemBinding,
        private val listener: (String) -> Unit,
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(user: GitHubUserResponse) {
            with(itemBinding) {
                itemWrapper.setOnClickListener {
                    listener(user.username)
                }

                Glide.with(context)
                    .load(user.avatar)
                    .centerCrop()
                    .into(avatar)

                tvLabel.text = user.username
            }
        }
    }
}