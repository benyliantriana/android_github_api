package com.example.githubapiapp.feature_users.data.response

import com.google.gson.annotations.SerializedName

data class GitHubSearchResponse(
    @SerializedName("total_count") val totalCount: Long,
    val items: List<GitHubUserResponse>,
)
