package com.example.urbannest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.PopupWindow

class InfoPop : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_pop)
    }

    // Function to display an information popup window
    private fun showPopup(){
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.activity_info_pop, null)

        // Defining the dimensions of the popup window
        val width = 850
        val height = 1000

        // The popup window with specified dimensions
        val instructWindow = PopupWindow(popupView, width, height, true)

        // Displaying the popup window at the bottom of the screen with specific offsets
        instructWindow.showAtLocation(popupView, Gravity.BOTTOM, 20, 800)

        // Setting up a click listener for the close button to dismiss the popup window
        val closeButton = popupView.findViewById<Button>(R.id.closeButton)
        closeButton.setOnClickListener{
            instructWindow.dismiss()
        }

    }
}