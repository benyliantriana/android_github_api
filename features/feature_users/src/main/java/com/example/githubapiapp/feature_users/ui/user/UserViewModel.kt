package com.example.githubapiapp.feature_users.ui.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapiapp.feature_users.data.ui.GitHubRepoListUiState
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
open class UserViewModel @Inject constructor(
    private val gitHubRepository: GitHubRepository,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {
    private var _userList = MutableStateFlow<GitHubRepoListUiState>(GitHubRepoListUiState.Loading)
    val userList: StateFlow<GitHubRepoListUiState?> get() = _userList

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch(ioDispatcher) {
            gitHubRepository.getUsers(1).collect { result ->
                when (result) {
                    is BaseResponse.Loading -> {
                        _userList.value = GitHubRepoListUiState.Loading
                    }

                    is BaseResponse.Success -> {
                        _userList.value = GitHubRepoListUiState.Success(result.data)
                    }

                    is BaseResponse.Failed -> {
                        _userList.value = GitHubRepoListUiState.Failed(result.code, result.message)
                    }
                }
            }
        }
    }

    fun searchUser(username: String) {
        viewModelScope.launch(ioDispatcher) {
            if (username.isEmpty()) {
                getUsers()
            } else {
                gitHubRepository.getSearchUser(username, 1).collect { result ->
                    when (result) {
                        is BaseResponse.Loading -> {
                            _userList.value = GitHubRepoListUiState.Loading
                        }

                        is BaseResponse.Success -> {
                            _userList.value = GitHubRepoListUiState.Success(result.data.items)
                        }

                        is BaseResponse.Failed -> {
                            _userList.value =
                                GitHubRepoListUiState.Failed(result.code, result.message)
                        }
                    }
                }
            }
        }
    }
}