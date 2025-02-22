package com.example.githubapiapp.feature_users.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.githubapiapp.feature_users.R
import com.example.githubapiapp.feature_users.databinding.UsersActivityBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * This class should be moved to feature main that has the navigation graph
 * for now just keep it like this because it's only has one feature
 */
@AndroidEntryPoint
class UsersActivity : AppCompatActivity() {
    private lateinit var binding: UsersActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setBinding()
        setContentView(binding.root)
        setNavHost()
    }

    private fun setBinding() {
        binding = UsersActivityBinding.inflate(layoutInflater)
    }

    private fun setNavHost() {
        findNavController(R.id.nav_host_fragment)
    }
}
