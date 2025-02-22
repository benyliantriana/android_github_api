package com.example.githubapiapp.feature_users.data.ui

import com.example.githubapiapp.feature_users.data.response.GitHubUserResponse

sealed class GitHubRepoListUiState {
    data object Loading : GitHubRepoListUiState()
    data class Success(val userList: List<GitHubUserResponse>) : GitHubRepoListUiState()
    data class Failed(val code: Int, val message: String) : GitHubRepoListUiState()
}
