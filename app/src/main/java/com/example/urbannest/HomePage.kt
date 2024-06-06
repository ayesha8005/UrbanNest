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

    private lateinit var bottomNavigationView : BottomNavigationView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)









        val welcomeTextView: TextView = findViewById(R.id.welcomeText)


        // Get user's name from intent extras
        val name = intent.getStringExtra("name")

        // Display welcome message
        welcomeTextView.text = "Welcome, $name!"

        //fragment
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bottom_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.bottom_favorites -> {
                    replaceFragment(FavoritesFragment())
                    true
                }
                R.id.bottom_cart -> {
                    replaceFragment(CartFragment())
                    true
                }
                R.id.bottom_profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false

            }



        }
        replaceFragment(HomeFragment())
    }




    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }


}
