package com.example.githubapiapp.feature_users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.githubapiapp.feature_users.databinding.UserFragmentBinding

class UserFragment : BaseFragment<UserFragmentBinding>() {
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
    }
}