package com.example.uf1_proyecto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.databinding.ItemViewBinding
import com.example.uf1_proyecto.model.Restaurant

// Una vez View Binding está habiltado se genera automáticamente una clase binding para cada XML que
// tenga un layout. En este caso el archivo item_view.xml tiene un TextView y un ImageView al que
// podemos acceder de manera segura gracias a que el generador View Binding crea la clase
// ItemViewBinding con las propiedades correspondientes


class ItemAdapter (
    private val context: Context,
    private val dataset: List<Restaurant>,
    private val onITemClick: (Restaurant) -> Unit
        ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    class ItemViewHolder(val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root)
    // binding.root es el CardView que contiene las vistas de ese ítem


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

        holder.binding.textViewRestaurantName.text = context.resources.getString(restaurant.stringResourceId)
        holder.binding.ivImage.setImageResource(restaurant.drawableResourceId)

        // Configura el clic del binding.root (Card View)
        holder.binding.root.setOnClickListener {
            onITemClick(restaurant)
        }
    }

}
