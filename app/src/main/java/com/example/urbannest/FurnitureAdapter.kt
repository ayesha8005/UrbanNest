package com.example.urbannest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FurnitureAdapter(
    private val furnitureList: List<FurnitureItem>,
    private val listener: OnItemClickListener?
) : RecyclerView.Adapter<FurnitureAdapter.FurnitureViewHolder>() {

    interface OnItemClickListener {
        fun onAddToCartClick(item: FurnitureItem)
        fun onAddToFavoritesClick(item: FurnitureItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FurnitureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_furniture, parent, false)
        return FurnitureViewHolder(view)
    }

    override fun onBindViewHolder(holder: FurnitureViewHolder, position: Int) {
        val currentItem = furnitureList[position]
        holder.bind(currentItem, listener)
    }

    override fun getItemCount() = furnitureList.size

    class FurnitureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.item_image_view)
        private val nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.description_text_view)
        private val priceTextView: TextView = itemView.findViewById(R.id.price_text_view)
        private val addToCartButton: Button = itemView.findViewById(R.id.add_to_cart_button)
        private val addToFavoritesButton: Button = itemView.findViewById(R.id.add_to_favorites_button)

        fun bind(item: FurnitureItem, listener: OnItemClickListener?) {
            nameTextView.text = item.name
            descriptionTextView.text = item.description
            priceTextView.text = item.price.toString()
            imageView.setImageResource(item.imageResId)
            addToCartButton.setOnClickListener { listener?.onAddToCartClick(item) }
            addToFavoritesButton.setOnClickListener { listener?.onAddToFavoritesClick(item) }
        }
    }
}
