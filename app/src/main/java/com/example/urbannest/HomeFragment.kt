package com.example.urbannest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FurnitureAdapter
    private lateinit var furnitureList: List<FurnitureItem>
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize the shared ViewModel
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        // Set up the RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Dummy data for the furniture list
        furnitureList = listOf(
            FurnitureItem("Elegant Sofa", "Comfortable and luxurious sofa for your living room.", 499.99, R.drawable.chairyal),
            FurnitureItem("Modern Blue Sofa", "Stylish and chic blue sofa to add a pop of color.", 199.99, R.drawable.bluesofa),
            FurnitureItem("Sleek Dining Table", "Modern dining table perfect for family dinners.", 299.99, R.drawable.bluetable),
            FurnitureItem("Golden Lamp", "Elegant golden lamp to brighten up your room.", 99.99, R.drawable.goldenlamp),
            FurnitureItem("Cozy Rug", "Plush and soft rug to enhance your living space.", 149.99, R.drawable.rug),
            FurnitureItem("Wooden Coffee Table", "Rustic wooden coffee table for a warm touch.", 249.99, R.drawable.woodentable),
            FurnitureItem("Comfortable Bed", "Spacious and comfortable bed for a restful sleep.", 399.99, R.drawable.bed),
            FurnitureItem("Center Table", "Stylish center table to complete your living room.", 249.99, R.drawable.centertable)
        )

        // Initialize the adapter with the furniture list and set up click listeners
        adapter = FurnitureAdapter(furnitureList, object : FurnitureAdapter.OnItemClickListener {
            override fun onAddToCartClick(item: FurnitureItem) {
                // Add item to the cart through the shared ViewModel
                sharedViewModel.addToCart(item)
            }
            override fun onAddToFavoritesClick(item: FurnitureItem) {
                // Add item to the favorites through the shared ViewModel
                sharedViewModel.addToFavorites(item)
            }
        })
        // Set the adapter to the RecyclerView
        recyclerView.adapter = adapter
        // Return the view for this fragment
        return view
    }
}
