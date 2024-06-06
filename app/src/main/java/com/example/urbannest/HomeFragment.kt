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
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Dummy data
        furnitureList = listOf(
            FurnitureItem("Sofa", "Comfortable sofa", 499.99, R.drawable.chairyal),
            FurnitureItem("Chair", "Stylish chair", 199.99, R.drawable.bluesofa),
            FurnitureItem("Chair", "Stylish chair", 199.99, R.drawable.bluetable),
            //FurnitureItem("Chair", "Stylish chair", 199.99, R.drawable.),
            FurnitureItem("Chair", "Stylish chair", 199.99, R.drawable.rug),
            //FurnitureItem("Chair", "Stylish chair", 199.99, R.drawable.yellowlamp),
            //FurnitureItem("Chair", "Stylish chair", 199.99, R.drawable.tablestool),
            FurnitureItem("Chair", "Stylish chair", 199.99, R.drawable.centertable)

            // Add more items...
        )

        adapter = FurnitureAdapter(furnitureList, object : FurnitureAdapter.OnItemClickListener {
            override fun onAddToCartClick(item: FurnitureItem) {
                sharedViewModel.addToCart(item)
            }

            override fun onAddToFavoritesClick(item: FurnitureItem) {
                sharedViewModel.addToFavorites(item)
            }
        })

        recyclerView.adapter = adapter

        return view
    }
}
