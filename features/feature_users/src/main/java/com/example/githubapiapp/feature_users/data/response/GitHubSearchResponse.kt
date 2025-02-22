package com.example.githubapiapp.feature_users.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubSearchResponse(
    @SerialName("total_count") val totalCount: Long,
    val items: List<GitHubUserResponse>,
)
