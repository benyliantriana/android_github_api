package com.example.githubapiapp.feature_users.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubUserDetailResponse(
    val id: Long,
    @SerialName("login") val username: String,
    @SerialName("avatar_url") val avatar: String,
    val name: String,
    val company: String,
    val location: String,
    val email: String,
    val bio: String,
    @SerialName("public_repos") val repo: Long,
    val followers: Long,
    val following: Long,
)
