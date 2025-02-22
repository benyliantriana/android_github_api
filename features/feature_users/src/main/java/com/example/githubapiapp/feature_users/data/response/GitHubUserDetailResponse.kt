package com.example.githubapiapp.feature_users.data.response

import com.google.gson.annotations.SerializedName

data class GitHubUserDetailResponse(
    @SerializedName("login") val username: String,
    val id: Long,
    @SerializedName("avatar_url") val avatar: String,
    @SerializedName("html_url") val github: String,
    val name: String,
    val company: String,
    val blog: String,
    val location: String,
    val email: String,
    val bio: String,
    @SerializedName("twitter_username") val twitter: String,
    @SerializedName("public_repos") val repos: Long,
    @SerializedName("public_gists") val gists: Long,
    val followers: Long,
    val following: Long,
    var repoList: List<GitHubRepoResponse> = emptyList()
)
