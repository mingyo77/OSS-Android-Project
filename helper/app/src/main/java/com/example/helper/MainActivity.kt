package com.example.helper

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.helper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment(), "Home_INIT")
        }
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(HomeFragment(), "HOME_TAB")
                    true
                }
                R.id.navigation_task -> {
                    replaceFragment(TaskFragment(), "TASK_TAB")
                    true
                }
                R.id.navigation_cooking -> {
                    replaceFragment(CookingFragment(), "COOKING_TAB")
                    true
                }
                R.id.navigation_manage -> {
                    replaceFragment(ManageFragment(), "MANAGE_TAB")
                    true
                }
                R.id.navigation_profile -> {
                    replaceFragment(ProfileFragment(), "PROFILE_TAB")
                    true
                }
                else -> false
            }
        }
    }
    private fun replaceFragment(fragment: Fragment, tag: String) {
        // Bundle을 통해 데이터를 전달
        val bundle = Bundle()
        bundle.putString("from_where", tag)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment) // activity_main.xml의 FrameLayout ID
            .commit()
    }
}