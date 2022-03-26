package com.pro.patentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pro.patentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding

        private val preferences get() = Injector.preferences

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
//        initFragment()

            if (preferences.getEmail("EMAIL") == ""){
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, RegFragment())
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, LoginFragment())
                    .commit()
            }
    }
}