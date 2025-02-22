package com.example.githubapiapp.feature_users.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubUserResponse(
    val id: Long,
    @SerialName("login") val username: String,
    @SerialName("avatar_url") val avatar: String,
    val url: String,
)
