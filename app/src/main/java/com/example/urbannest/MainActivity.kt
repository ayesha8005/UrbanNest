package com.example.urbannest

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {


    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        nameEditText = findViewById(R.id.nameText)
        emailEditText = findViewById(R.id.emailText)
        passwordEditText = findViewById(R.id.passwordText)

        val loginButton: Button = findViewById(R.id.doneButton)
        loginButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Store user data in SharedPreferences
            val editor: SharedPreferences.Editor =
                getSharedPreferences("userData", MODE_PRIVATE).edit()
            editor.putString("name", name)
            editor.putString("email", email)
            editor.putString("password", password)
            editor.apply()

            // Navigate to WelcomeActivity
            val intent = Intent(this, HomePage::class.java)
            intent.putExtra("name", name)
            startActivity(intent)

        }

    }
}