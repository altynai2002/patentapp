package com.pro.patentapp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pro.patentapp.databinding.FragmentAuthBinding

class AuthFragment: Fragment(R.layout.fragment_auth) {
    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: OnClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAuthBinding.bind(view)

        binding.apply {
            loginBtn.setOnClickListener {
                listener.onClick("login")
            }
            registrationBtn.setOnClickListener {
                listener.onClick("register")
            }
        }

    }
}