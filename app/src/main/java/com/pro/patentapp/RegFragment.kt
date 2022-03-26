package com.pro.patentapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.pro.patentapp.databinding.FragmentRegBinding
import java.util.*

class RegFragment : Fragment(R.layout.fragment_reg) {
    private var _binding: FragmentRegBinding? = null
    private val binding get() = _binding!!

    private val preferences get() = Injector.preferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentRegBinding.bind(view)
        val cal = Calendar.getInstance()
        val mYear = cal.get(Calendar.YEAR)
        val mMonth = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        binding.apply {

            dateOfIssue.setOnClickListener {
                val datePickerDialog = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->

                    dateOfIssue.setText( "$dayOfMonth/" + (month+1) + "/" + year)

                }, mYear, mMonth, day)
                datePickerDialog.show()

            }

            btnReg.setOnClickListener {
//                if (!isValidEmail(pin.text.toString())) {
//                    Toast.makeText(activity, "Неккоректная почта", Toast.LENGTH_SHORT).show()
                if (pin.length() != 14) {
                    Toast.makeText(activity, "Неккоректный ПИН", Toast.LENGTH_SHORT).show()
                } else {
                    preferences.savePin(pin.text.toString())
                    preferences.savePassword(password.text.toString())
                    preferences.saveName(name.text.toString())
                    preferences.saveSurname(surname.text.toString())
                    preferences.saveOtchestvo(otchestvo.text.toString())
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

    private fun isValidPin(pin: String): Boolean {
        return !TextUtils.isEmpty(pin) && Patterns.EMAIL_ADDRESS.matcher(pin).matches()
    }
}