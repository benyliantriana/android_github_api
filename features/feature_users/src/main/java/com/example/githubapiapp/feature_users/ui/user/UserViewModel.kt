package com.example.githubapiapp.feature_users.ui.user

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapiapp.feature_users.repository.GitHubRepository
import com.example.githubapiapp.lib_base.di.IODispatcher
import com.example.githubapiapp.lib_network.response.BaseResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class UserViewModel @Inject constructor(
    private val gitHubRepository: GitHubRepository,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {
//    init {
//        getUsers()
//    }

    fun getUsers() {
        viewModelScope.launch(ioDispatcher) {
            gitHubRepository.getUsers(1).collect { result ->
                Log.d("suasu", result.toString())
                when (result) {
                    is BaseResponse.Loading -> {

                    }

                    is BaseResponse.Success -> {
                    }

                    is BaseResponse.Failed -> {

                    }
                }
            }
        }
    }
}