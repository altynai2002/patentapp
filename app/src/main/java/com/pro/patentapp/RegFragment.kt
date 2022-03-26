package com.pro.patentapp

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.pro.patentapp.databinding.FragmentRegBinding

class RegFragment : Fragment(R.layout.fragment_reg) {
    private var _binding: FragmentRegBinding? = null
    private val binding get() = _binding!!

    private val preferences get() = Injector.preferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentRegBinding.bind(view)


        binding.apply {
            btnReg.setOnClickListener {
                if (!isValidEmail(email.text.toString())) {
                    Toast.makeText(activity, "Неккоректная почта", Toast.LENGTH_SHORT).show()
                } else {
                    preferences.saveEmail(email.text.toString())
                    preferences.savePassword(password.text.toString())
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, MainFragment())
                        .commit()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}