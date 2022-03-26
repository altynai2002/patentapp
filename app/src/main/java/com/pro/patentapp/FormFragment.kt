package com.pro.patentapp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pro.patentapp.databinding.FragmentAuthBinding
import com.pro.patentapp.databinding.FragmentFormBinding

class FormFragment: Fragment(R.layout.fragment_form) {
    private var _binding: FragmentFormBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: OnClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFormBinding.bind(view)

//        binding.apply {
//            loginBtn.setOnClickListener {
//                listener.onClick("login")
//            }
//            registrationBtn.setOnClickListener {
//                listener.onClick("register")
//            }
//        }

    }
}