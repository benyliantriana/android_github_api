package com.example.githubapiapp.feature_users

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.githubapiapp.feature_users.databinding.UsersActivityBinding

class UsersActivity : AppCompatActivity() {
    private lateinit var binding: UsersActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setContentView(binding.root)
        setStatusBarColor()
    }

    private fun setBinding() {
        binding = UsersActivityBinding.inflate(layoutInflater)
    }

    private fun setStatusBarColor() {
        window.statusBarColor = ContextCompat.getColor(this, R.color.navy)
    }
}
