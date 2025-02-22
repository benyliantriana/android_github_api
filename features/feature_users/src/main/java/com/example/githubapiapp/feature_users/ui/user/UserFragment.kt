package com.example.githubapiapp.feature_users.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.githubapiapp.feature_users.R
import com.example.githubapiapp.feature_users.databinding.UserFragmentBinding
import com.example.githubapiapp.lib_base.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : BaseFragment<UserFragmentBinding>() {
    private val userViewModel by viewModels<UserViewModel>()

    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean,
    ): UserFragmentBinding = UserFragmentBinding.inflate(inflater, container, attachToRoot)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layout.btnDetail.setOnClickListener {
            findNavController().navigate(R.id.action_user_to_detail)
        }

        userViewModel.getUsers()
    }
}