package com.example.urbannest

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService



class ProfileFragment : Fragment() {

    private lateinit var showPopupInstruct : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the button
        showPopupInstruct = view.findViewById(R.id.show_popup_button)

        // Set the click listener to show the popup
        showPopupInstruct.setOnClickListener {
            showPopup()
        }
    }

    // Function to display an information popup window
    private fun showPopup() {
        val inflater = requireActivity().getSystemService(AppCompatActivity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
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
        closeButton.setOnClickListener {
            instructWindow.dismiss()
        }
    }
}
