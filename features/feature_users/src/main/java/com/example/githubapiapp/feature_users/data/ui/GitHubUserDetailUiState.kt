package com.example.githubapiapp.feature_users.data.ui

import com.example.githubapiapp.feature_users.data.response.GitHubUserDetailResponse

sealed class GitHubUserDetailUiState {
    data object Loading : GitHubUserDetailUiState()
    data class Success(val user: GitHubUserDetailResponse) : GitHubUserDetailUiState()
    data class Failed(val code: Int, val message: String) : GitHubUserDetailUiState()
}
