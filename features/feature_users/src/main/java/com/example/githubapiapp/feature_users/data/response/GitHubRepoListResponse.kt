package com.example.githubapiapp.feature_users.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubRepoListResponse(
    val id: Long,
    val name: String,
    @SerialName("full_name") val fullName: String,
    @SerialName("html_url") val url: String,
    val description: String,
    val fork: Boolean,
    @SerialName("stargazers_count") val stars: Long,
    val language: String,
)
