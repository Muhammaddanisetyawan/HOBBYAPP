package com.ubaya.hobbyapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ubaya.hobbyapp.R
import com.ubaya.hobbyapp.databinding.ActivityMainBinding
import com.ubaya.hobbyapp.ui.news.NewsListFragment
import com.ubaya.hobbyapp.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(NewsListFragment())

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_news -> loadFragment(NewsListFragment())
                R.id.nav_profile -> loadFragment(ProfileFragment())
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
