package com.example.githubapiapp.feature_users.datasource.remote

import com.example.githubapiapp.feature_users.data.response.GitHubRepoListResponse
import com.example.githubapiapp.feature_users.data.response.GitHubSearchResponse
import com.example.githubapiapp.feature_users.data.response.GitHubUserDetailResponse
import com.example.githubapiapp.feature_users.data.response.GitHubUserResponse
import com.example.githubapiapp.lib_network.response.BaseResponse

interface GitHubRemoteDataSource {
    suspend fun getUsers(page: Int): BaseResponse<List<GitHubUserResponse>>
    suspend fun getSearchUser(name: String, page: Int): BaseResponse<List<GitHubSearchResponse>>
    suspend fun getDetailUser(username: String): BaseResponse<GitHubUserDetailResponse>
    suspend fun getUserRepos(username: String): BaseResponse<List<GitHubRepoListResponse>>
}
