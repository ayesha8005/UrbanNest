package com.example.urbannest

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    // Declare EditText variables for name, email, and password input fields
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content view to the activity_main layout
        setContentView(R.layout.activity_main)

        // Initialize the EditText variables
        nameEditText = findViewById(R.id.nameText)
        emailEditText = findViewById(R.id.emailText)
        passwordEditText = findViewById(R.id.passwordText)


        // Initialize the login button and set an OnClickListener
        val loginButton: Button = findViewById(R.id.doneButton)
        loginButton.setOnClickListener {
            // Get text from the EditText fields
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Store user data in SharedPreferences
            val editor: SharedPreferences.Editor =
                getSharedPreferences("userData", MODE_PRIVATE).edit()
            editor.putString("name", name)
            editor.putString("email", email)
            editor.putString("password", password)
            editor.apply() // Apply the changes

            // Navigate to HomePage activity
            val intent = Intent(this, HomePage::class.java)
            intent.putExtra("name", name) // Pass the user's name to HomePage
            startActivity(intent) // Start the HomePage activity

        }

    }
}