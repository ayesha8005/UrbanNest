package com.example.urbannest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FurnitureAdapter
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        sharedViewModel.cartItems.observe(viewLifecycleOwner) { cartItems ->
            adapter = FurnitureAdapter(cartItems, null)
            recyclerView.adapter = adapter
        }

        return view
    }
}
