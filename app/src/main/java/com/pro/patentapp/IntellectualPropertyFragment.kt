package com.pro.patentapp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pro.patentapp.databinding.FragmentIntellectualPropertyBinding


class IntellectualPropertyFragment: Fragment(R.layout.fragment_intellectual_property) {
    private var _binding: FragmentIntellectualPropertyBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: OnClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentIntellectualPropertyBinding.bind(view)

        binding.apply {
            formsBtn.setOnClickListener {
                listener.onClick("forms")
            }
        }

    }
}