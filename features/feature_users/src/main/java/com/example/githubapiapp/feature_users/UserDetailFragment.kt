package com.example.githubapiapp.feature_users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.githubapiapp.feature_users.databinding.UserDetailFragmentBinding

class UserDetailFragment : BaseFragment<UserDetailFragmentBinding>() {
    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean,
    ): UserDetailFragmentBinding =
        UserDetailFragmentBinding.inflate(inflater, container, attachToRoot)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layout.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}