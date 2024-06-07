package com.example.urbannest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Locale

class HomePage : AppCompatActivity() {

    // Declare the bottom navigation view
    private lateinit var bottomNavigationView : BottomNavigationView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        // Find and initialize the TextView for the welcome message
        val welcomeTextView: TextView = findViewById(R.id.welcomeText)

        // Get user's name from intent extras
        val name = intent.getStringExtra("name")

        // Display the welcome message with the user's name
        welcomeTextView.text = "Welcome, $name!"

        // Find and initialize the bottom navigation view
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // Set a listener for item selection in the bottom navigation view
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bottom_home -> {
                    // Replace the current fragment with HomeFragment
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.bottom_favorites -> {
                    // Replace the current fragment with FavoritesFragment
                    replaceFragment(FavoritesFragment())
                    true
                }
                R.id.bottom_cart -> {
                    // Replace the current fragment with CartFragment
                    replaceFragment(CartFragment())
                    true
                }
                R.id.bottom_profile -> {
                    // Replace the current fragment with ProfileFragment
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false

            }
        }
        // Set the initial fragment to HomeFragment
        replaceFragment(HomeFragment())
    }
    // Helper function to replace the current fragment with the specified fragment
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
}
