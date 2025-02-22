package com.example.githubapiapp.feature_users.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapiapp.feature_users.data.ui.GitHubUserDetailUiState
import com.example.githubapiapp.feature_users.repository.GitHubRepository
import com.example.githubapiapp.lib_base.di.IODispatcher
import com.example.githubapiapp.lib_network.response.BaseResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class UserDetailViewModel @Inject constructor(
    private val gitHubRepository: GitHubRepository,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {
    private var _userData = MutableStateFlow<GitHubUserDetailUiState?>(
        GitHubUserDetailUiState.Loading
    )
    val userData: StateFlow<GitHubUserDetailUiState?> get() = _userData

    private var _username = MutableStateFlow<String?>(null)
    val username: StateFlow<String?> get() = _username

    fun setUsername(username: String) {
        _username.value = username
    }

    fun getUserDetail() {
        viewModelScope.launch(ioDispatcher) {
            username.value?.let {
                gitHubRepository.getDetailUser(it).collect { result ->
                    when (result) {
                        is BaseResponse.Loading -> {
                            _userData.value = GitHubUserDetailUiState.Loading
                        }

                        is BaseResponse.Success -> {
                            _userData.value = GitHubUserDetailUiState.Success(result.data)
                        }

                        is BaseResponse.Failed -> {
                            _userData.value =
                                GitHubUserDetailUiState.Failed(result.code, result.message)
                        }
                    }
                }
            }
        }
    }
}
