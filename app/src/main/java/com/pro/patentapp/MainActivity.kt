package com.pro.patentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pro.patentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClick {

    private lateinit var binding: ActivityMainBinding

    private val preferences get() = Injector.preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragment()

//        if (preferences.getEmail("EMAIL") == ""){
//            supportFragmentManager.beginTransaction()
//                .add(R.id.fragment_container, RegFragment())
//                .commit()
//        } else {
//            supportFragmentManager.beginTransaction()
//                .add(R.id.fragment_container, LoginFragment())
//                .commit()
//        }
    }

    override fun onClick(frId: String) {
        if (frId == "login") {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment())
                .commit()
        }
        else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RegFragment())
                .commit()
        }

//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragment_container, MainFragment())
//            .commit()
    }

    override fun onObject() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, IntellectualPropertyFragment())
            .addToBackStack(null)
            .commit()
    }


    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, AuthFragment())
            .commit()
    }

}