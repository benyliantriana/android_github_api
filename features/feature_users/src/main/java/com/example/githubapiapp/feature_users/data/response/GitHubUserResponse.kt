package com.example.githubapiapp.feature_users.data.response

import com.google.gson.annotations.SerializedName

data class GitHubUserResponse(
    @SerializedName("login") val username: String,
    val id: Long,
    @SerializedName("node_id") val nodeId: String,
    @SerializedName("avatar_url") val avatar: String,
)