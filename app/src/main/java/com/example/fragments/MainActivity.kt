package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.ActivityMainBinding
import com.example.fragments.fragments.HomeFragment
import com.example.fragments.fragments.ProfileFragment
import com.example.fragments.fragments.SettingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // menentukan fragment mana yang akan ditampilkan terlebih dulu -> fragment home
        replaceFragment(HomeFragment())
        //

        // logic di bawah digunakan untuk mengganti fragment saat item pada bottom nav dipilih
        binding.navButton.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
                R.id.setting -> replaceFragment(SettingFragment())
            }
            true
        }
        //
    }

    // membuat function untuk mengganti-ganti fragment menggunakan .replace
    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // replace(layout yg diganti, layout yg menggantikan)
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        //
        fragmentTransaction.commit()

    }
    //
}