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
                .replace(R.id.fragment_container, MainFragment())
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

    override fun onClickPublications() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, PublicationsFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onClickPublicServices() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, PublicServicesFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onClickInnovations() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, InnovationsFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onClickAbout() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, AboutUsFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onClickSearch() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SearchFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, AuthFragment())
            .commit()
    }
}