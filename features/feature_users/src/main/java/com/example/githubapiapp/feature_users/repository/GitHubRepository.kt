package com.example.githubapiapp.feature_users.repository

import com.example.githubapiapp.feature_users.data.response.GitHubRepoResponse
import com.example.githubapiapp.feature_users.data.response.GitHubSearchResponse
import com.example.githubapiapp.feature_users.data.response.GitHubUserDetailResponse
import com.example.githubapiapp.feature_users.data.response.GitHubUserResponse
import com.example.githubapiapp.lib_network.response.BaseResponse
import kotlinx.coroutines.flow.Flow

interface GitHubRepository {
    suspend fun getUsers(page: Int): Flow<BaseResponse<List<GitHubUserResponse>>>
    suspend fun getSearchUser(name: String, page: Int): Flow<BaseResponse<GitHubSearchResponse>>
    suspend fun getDetailUser(username: String): Flow<BaseResponse<GitHubUserDetailResponse>>
    suspend fun getUserRepos(username: String): Flow<BaseResponse<List<GitHubRepoResponse>>>
}
