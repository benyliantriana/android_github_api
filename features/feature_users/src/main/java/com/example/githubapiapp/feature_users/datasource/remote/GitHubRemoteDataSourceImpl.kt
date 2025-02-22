package com.example.githubapiapp.feature_users.datasource.remote

import com.example.githubapiapp.feature_users.api.GitHubApi
import com.example.githubapiapp.feature_users.data.response.GitHubRepoListResponse
import com.example.githubapiapp.feature_users.data.response.GitHubSearchResponse
import com.example.githubapiapp.feature_users.data.response.GitHubUserDetailResponse
import com.example.githubapiapp.feature_users.data.response.GitHubUserResponse
import com.example.githubapiapp.lib_base.di.IODispatcher
import com.example.githubapiapp.lib_network.response.BaseResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse
import javax.inject.Inject

class GitHubRemoteDataSourceImpl @Inject constructor(
    private val gitHubApi: GitHubApi,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
) : GitHubRemoteDataSource {
    override suspend fun getUsers(page: Int): BaseResponse<List<GitHubUserResponse>> =
        withContext(ioDispatcher) {
            val defaultExceptionData =
                com.example.githubapiapp.lib_base.exception.getDefaultRemoteException()
            var responseResult: BaseResponse<List<GitHubUserResponse>> = BaseResponse.Failed(
                code = defaultExceptionData.code, message = defaultExceptionData.message
            )
            val result = gitHubApi.getUsers(page).awaitResponse()
            if (result.isSuccessful) {
                result.body()?.let {
                    responseResult = BaseResponse.Success(it)
                }
            } else {
                responseResult = BaseResponse.Failed(result.code(), result.message())
            }
            return@withContext responseResult
        }

    override suspend fun getSearchUser(
        name: String,
        page: Int,
    ): BaseResponse<List<GitHubSearchResponse>> = withContext(ioDispatcher) {
        val defaultExceptionData =
            com.example.githubapiapp.lib_base.exception.getDefaultRemoteException()
        var responseResult: BaseResponse<List<GitHubSearchResponse>> = BaseResponse.Failed(
            code = defaultExceptionData.code, message = defaultExceptionData.message
        )
        val result = gitHubApi.searchUsers(name, page).awaitResponse()
        if (result.isSuccessful) {
            result.body()?.let {
                responseResult = BaseResponse.Success(it)
            }
        } else {
            responseResult = BaseResponse.Failed(result.code(), result.message())
        }
        return@withContext responseResult
    }

    override suspend fun getDetailUser(username: String): BaseResponse<GitHubUserDetailResponse> =
        withContext(ioDispatcher) {
            val defaultExceptionData =
                com.example.githubapiapp.lib_base.exception.getDefaultRemoteException()
            var responseResult: BaseResponse<GitHubUserDetailResponse> = BaseResponse.Failed(
                code = defaultExceptionData.code, message = defaultExceptionData.message
            )
            val result = gitHubApi.getUserDetails(username).awaitResponse()
            if (result.isSuccessful) {
                result.body()?.let {
                    responseResult = BaseResponse.Success(it)
                }
            } else {
                responseResult = BaseResponse.Failed(result.code(), result.message())
            }
            return@withContext responseResult
        }

    override suspend fun getUserRepos(username: String): BaseResponse<List<GitHubRepoListResponse>> =
        withContext(ioDispatcher) {
            val defaultExceptionData =
                com.example.githubapiapp.lib_base.exception.getDefaultRemoteException()
            var responseResult: BaseResponse<List<GitHubRepoListResponse>> = BaseResponse.Failed(
                code = defaultExceptionData.code, message = defaultExceptionData.message
            )
            val result = gitHubApi.getUserRepos(username).awaitResponse()
            if (result.isSuccessful) {
                result.body()?.let {
                    responseResult = BaseResponse.Success(it)
                }
            } else {
                responseResult = BaseResponse.Failed(result.code(), result.message())
            }
            return@withContext responseResult
        }
}
