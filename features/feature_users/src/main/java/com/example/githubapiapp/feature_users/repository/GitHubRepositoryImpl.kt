package com.example.githubapiapp.feature_users.repository

import com.example.githubapiapp.feature_users.data.response.GitHubRepoListResponse
import com.example.githubapiapp.feature_users.data.response.GitHubSearchResponse
import com.example.githubapiapp.feature_users.data.response.GitHubUserDetailResponse
import com.example.githubapiapp.feature_users.data.response.GitHubUserResponse
import com.example.githubapiapp.feature_users.datasource.remote.GitHubRemoteDataSource
import com.example.githubapiapp.lib_network.response.BaseResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(
    private val gitHubRemoteDataSource: GitHubRemoteDataSource,
) : GitHubRepository {
    override suspend fun getUsers(page: Int): Flow<BaseResponse<List<GitHubUserResponse>>> = flow {
        emit(BaseResponse.Loading)
        emit(gitHubRemoteDataSource.getUsers(page))
    }

    override suspend fun getSearchUser(
        name: String,
        page: Int,
    ): Flow<BaseResponse<List<GitHubSearchResponse>>> = flow {
        emit(BaseResponse.Loading)
        emit(gitHubRemoteDataSource.getSearchUser(name, page))
    }

    override suspend fun getDetailUser(username: String): Flow<BaseResponse<GitHubUserDetailResponse>> =
        flow {
            emit(BaseResponse.Loading)
            emit(gitHubRemoteDataSource.getDetailUser(username))
        }

    override suspend fun getUserRepos(username: String): Flow<BaseResponse<List<GitHubRepoListResponse>>> =
        flow {
            emit(BaseResponse.Loading)
            emit(gitHubRemoteDataSource.getUserRepos(username))
        }
}