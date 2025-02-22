package com.example.githubapiapp.feature_users.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.githubapiapp.feature_users.R
import com.example.githubapiapp.feature_users.data.response.GitHubUserDetailResponse
import com.example.githubapiapp.feature_users.data.ui.GitHubUserDetailUiState
import com.example.githubapiapp.feature_users.databinding.UserDetailFragmentBinding
import com.example.githubapiapp.lib_base.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserDetailFragment : BaseFragment<UserDetailFragmentBinding>() {

    private val args: UserDetailFragmentArgs by navArgs()
    private lateinit var viewModel: UserDetailViewModel
    override fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean,
    ): UserDetailFragmentBinding =
        UserDetailFragmentBinding.inflate(inflater, container, attachToRoot)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVm()
        initAppBar()
        initUserDetailData()
    }

    private fun initVm() {
        viewModel = ViewModelProvider(this)[UserDetailViewModel::class.java]
        viewModel.setUsername(args.username)
        viewModel.getUserDetail()
    }

    private fun initAppBar() {
        lifecycleScope.launch {
            viewModel.username.flowWithLifecycle(lifecycle).collect {
                layout.label.text = it
                layout.backButton.setOnClickListener {
                    findNavController().navigateUp()
                }
            }
        }
    }

    private fun initUserDetailData() {
        lifecycleScope.launch {
            viewModel.userData.flowWithLifecycle(lifecycle).collect { uiState ->
                uiState?.let {
                    when (it) {
                        is GitHubUserDetailUiState.Loading -> {
                            loadingView()
                        }

                        is GitHubUserDetailUiState.Success -> {
                            successView(it.user)
                        }

                        is GitHubUserDetailUiState.Failed -> {
                            // todo
                        }
                    }
                }
            }
        }
    }

    private fun loadingView() {
        with(layout) {
            loading.visibility = View.VISIBLE
            group.visibility = View.INVISIBLE
        }
    }

    private fun successView(user: GitHubUserDetailResponse) {
        with(layout) {
            loading.visibility = View.INVISIBLE
            group.visibility = View.VISIBLE

            Glide.with(requireContext())
                .load(user.avatar)
                .centerCrop()
                .circleCrop()
                .into(avatar)

            tvName.text = user.name
            tvUsername.text = getString(R.string.user_username, user.username)
            tvGithub.text = getString(R.string.user_github, user.github)
            tvCompany.text = getString(R.string.user_company, user.company)
            tvBlog.text = getString(R.string.user_blog, user.blog)
            tvLocation.text = getString(R.string.user_location, user.location)
            tvEmail.text = getString(R.string.user_email, user.email)
            tvBio.text = getString(R.string.user_bio, user.bio)
            tvTwitter.text = getString(R.string.user_twitter, user.twitter)
            tvRepos.text = getString(R.string.user_repos, user.repos)
            tvGists.text = getString(R.string.user_gists, user.gists)
            tvFollowers.text = getString(R.string.user_followers, user.followers)
            tvFollowing.text = getString(R.string.user_following, user.following)
        }
    }
}