package com.example.githubapiapp.feature_users.data.response

import com.google.gson.annotations.SerializedName

data class GitHubRepoListResponse(
    val id: Long,
    val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("html_url") val url: String,
    val description: String,
    val fork: Boolean,
    @SerializedName("stargazers_count") val stars: Long,
    val language: String,
)
