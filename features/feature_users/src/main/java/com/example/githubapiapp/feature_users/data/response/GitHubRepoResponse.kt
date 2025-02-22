package com.example.githubapiapp.feature_users.data.response

import com.google.gson.annotations.SerializedName

data class GitHubRepoResponse(
    val id: Long,
    val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("html_url") val github: String,
    val description: String,
    val fork: Boolean,
    @SerializedName("stargazers_count") val stars: Long,
    @SerializedName("watchers_count") val watcher: Long,
    val language: String,
)
