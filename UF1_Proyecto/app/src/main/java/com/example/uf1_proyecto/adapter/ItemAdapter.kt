package com.example.uf1_proyecto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.databinding.ItemViewBinding
import com.example.uf1_proyecto.data.Restaurant

// Una vez View Binding está habiltado se genera automáticamente una clase binding para cada XML que
// tenga un layout. En este caso el archivo item_view.xml tiene un TextView y un ImageView al que
// podemos acceder de manera segura gracias a que el generador View Binding crea la clase
// ItemViewBinding con las propiedades correspondientes


class ItemAdapter (
    private val context: Context,
    private val dataset: List<Restaurant>,
    private val onItemClick: (Restaurant) -> Unit
        ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root){
        // binding.root es el CardView que contiene las vistas de ese ítem

        val restaurantName: TextView = binding.textViewRestaurantName
        val restaurantImage: ImageView = binding.ivImage

        fun bind(restaurant: Restaurant, onItemClick: (Restaurant) -> Unit) {
            restaurantName.text = restaurant.name
            val imageResId = binding.root.context.resources.getIdentifier(restaurant.img, "drawable", binding.root.context.packageName)
            Glide.with(binding.root.context)
                .load(imageResId)
                .into(restaurantImage)

            itemView.setOnClickListener {
                onItemClick(restaurant)  // Llamamos al callback al hacer clic
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = dataset.size

    // Vincula los datos del modelo a las vistas correspnodientes de cada ítem de la lista que se
    // muestra en el RecyclerView. Es llamado cada vez que un nuevo ítem debe ser mostrado. Se
    // invoca para llenar las vistas del ViewHolder con datos.
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val restaurant = dataset[position]
        holder.bind(restaurant, onItemClick)
    }


}
