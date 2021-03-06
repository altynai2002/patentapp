package com.pro.patentapp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pro.patentapp.databinding.FragmentFormBinding
import com.pro.patentapp.databinding.FragmentProfileBinding

class ProfileFragment: Fragment(R.layout.fragment_profile) {
    private val preferences get() = Injector.preferences
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: OnClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileBinding.bind(view)

        val prefName = preferences.getName("NAME")

        binding.apply {
            name.text = prefName

            intelProp.setOnClickListener {
                listener.onClick("intelProp")
            }
        }
    }
}