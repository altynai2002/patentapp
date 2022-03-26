package com.pro.patentapp

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class LoginFragment: Fragment(R.layout.fragment_login)  {
    private val preferences get() = Injector.preferences

    private lateinit var btnLogin:AppCompatButton
    private lateinit var pin:AppCompatEditText
    private lateinit var password:AppCompatEditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prefPin = preferences.getPin("PIN")
        val prefPassword = preferences.getPassword("PASSWORD")

        pin = view.findViewById(R.id.pin)
        password = view.findViewById(R.id.password)
        btnLogin = view.findViewById(R.id.btnLogin)

        pin.addTextChangedListener(loginTextWatcher)
        password.addTextChangedListener(loginTextWatcher)

        btnLogin.setOnClickListener {
            if (pin.text.toString() == prefPin && password.text.toString() == prefPassword) {

                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, MainFragment())
                transaction.disallowAddToBackStack()
                transaction.commit()

            } else if (!isValidPin(pin.text.toString())) {
                Toast.makeText(activity, "Неккоректный ПИН", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Почта или пароль не совпадают", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidPin(pin: String): Boolean {
        return !TextUtils.isEmpty(pin)
    }

    private val loginTextWatcher = object :TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val emailText = pin.text.toString().trim()
            val passwordText = password.text.toString().trim()
            btnLogin.isEnabled = emailText.isNotEmpty() && passwordText.isNotEmpty()
        }

        override fun afterTextChanged(p0: Editable?) {}
    }

}