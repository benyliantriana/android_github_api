package com.example.githubapiapp.feature_users.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding> : Fragment() {
    var _layout: T? = null
    protected val layout: T
        get() = _layout
            ?: throw IllegalStateException("The fragment[${this.javaClass.name}] has been destroyed")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = inflateLayout(inflater, container, false)
        _layout = binding
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _layout = null
    }

    abstract fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ): T
}
