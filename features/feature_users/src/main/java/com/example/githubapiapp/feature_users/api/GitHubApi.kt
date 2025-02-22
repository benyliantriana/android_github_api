package com.example.githubapiapp.feature_users.api

import com.example.githubapiapp.feature_users.data.response.GitHubRepoListResponse
import com.example.githubapiapp.feature_users.data.response.GitHubSearchResponse
import com.example.githubapiapp.feature_users.data.response.GitHubUserDetailResponse
import com.example.githubapiapp.feature_users.data.response.GitHubUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {
    @GET("users")
    fun getUsers( 
        @Query("page") page: Int = 1,
    ): Call<List<GitHubUserResponse>>

    @GET("search/users")
    fun searchUsers(
        @Query("q") query: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
    ): Call<List<GitHubSearchResponse>>

    @GET("users/{username}")
    fun getUserDetails(@Path("username") username: String): Call<GitHubUserDetailResponse>

    @GET("users/{username}/repos")
    fun getUserRepos(@Path("username") username: String): Call<List<GitHubRepoListResponse>>
}
