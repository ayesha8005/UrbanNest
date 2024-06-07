package com.example.urbannest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreen : AppCompatActivity() {

    // Constant for the splash screen timeout duration (3000 milliseconds or 3 seconds)
    private val SPLASH_TIME_OUT: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view to the activity_splash_screen layout
        setContentView(R.layout.activity_splash_screen)

        // Use a Handler to delay the transition to MainActivity
        android.os.Handler().postDelayed({
            // Start the MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            // Finish the SplashScreen activity so the user cannot return to it
            finish()
        }, SPLASH_TIME_OUT)
    }
}