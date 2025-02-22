package com.example.githubapiapp.feature_users

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.githubapiapp.feature_users.databinding.UsersActivityBinding

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
