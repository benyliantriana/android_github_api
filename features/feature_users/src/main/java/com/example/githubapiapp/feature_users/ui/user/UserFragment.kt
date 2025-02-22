package com.example.githubapiapp.feature_users.ui.user

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapiapp.feature_users.data.response.GitHubUserResponse
import com.example.githubapiapp.feature_users.data.ui.GitHubRepoListUiState
import com.example.githubapiapp.feature_users.databinding.UserFragmentBinding
import com.example.githubapiapp.lib_base.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserFragment : BaseFragment<UserFragmentBinding>() {
    private lateinit var viewModel: UserViewModel
    private var userList = ArrayList<GitHubUserResponse>(arrayListOf())
    private lateinit var userAdapter: UserAdapter

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean,
    ): UserFragmentBinding = UserFragmentBinding.inflate(inflater, container, attachToRoot)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVm()
        initView()
        initUserList()
    }

    private fun initVm() {
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(context)
        userAdapter = UserAdapter(requireContext(), userList) {
            val action = UserFragmentDirections.actionUserToDetail(it)
            findNavController().navigate(action)
        }
        layout.rvUsers.apply {
            adapter = userAdapter
            this.layoutManager = layoutManager
        }
        layout.tvSearch.setOnClickListener {
            viewModel.searchUser(layout.etSearch.text.toString())
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initUserList() {
        lifecycleScope.launch {
            viewModel.userList.flowWithLifecycle(lifecycle).collect { list ->
                list?.let {
                    when (it) {
                        is GitHubRepoListUiState.Loading -> {
                            layout.rvUsers.visibility = View.INVISIBLE
                            layout.loading.visibility = View.VISIBLE
                        }

                        is GitHubRepoListUiState.Success -> {
                            userList.clear()
                            userList.addAll(it.userList)
                            userAdapter.notifyDataSetChanged()

                            layout.rvUsers.visibility = View.VISIBLE
                            layout.loading.visibility = View.INVISIBLE
                        }

                        is GitHubRepoListUiState.Failed -> {
                            // todo
                        }
                    }
                }
            }
        }
    }
}