package com.example.githubapiapp.feature_users.di

import com.example.githubapiapp.feature_users.api.GitHubApi
import com.example.githubapiapp.feature_users.datasource.remote.GitHubRemoteDataSource
import com.example.githubapiapp.feature_users.datasource.remote.GitHubRemoteDataSourceImpl
import com.example.githubapiapp.feature_users.repository.GitHubRepository
import com.example.githubapiapp.feature_users.repository.GitHubRepositoryImpl
import com.example.githubapiapp.lib_network.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleInjection {
    @IODispatcher
    @Provides
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun provideGitHubApi(
        apiService: ApiService,
    ): GitHubApi = apiService.service().create(GitHubApi::class.java)

    @Provides
    @Singleton
    fun provideGitHubRemoteDataSource(
        gitHubApi: GitHubApi,
        @IODispatcher ioDispatcher: CoroutineDispatcher,
    ): GitHubRemoteDataSource =
        GitHubRemoteDataSourceImpl(
            gitHubApi,
            ioDispatcher
        )

    @Provides
    @Singleton
    fun provideGitHubRepository(
        gitHubRemoteDataSource: GitHubRemoteDataSource,
    ): GitHubRepository =
        GitHubRepositoryImpl(
            gitHubRemoteDataSource
        )
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IODispatcher
