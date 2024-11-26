package com.example.uf1_proyecto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.databinding.MenuItemViewBinding
import com.example.uf1_proyecto.model.Menu
import com.example.uf1_proyecto.model.MenuItem

class MenuItemAdapter(
    private val context: Context,
    private val dataset: Menu?
        ) : RecyclerView.Adapter<MenuItemAdapter.MenuItemViewHolder>(){

    class MenuItemViewHolder(val binding: MenuItemViewBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val binding = MenuItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset?.categories?.sumOf { it.items.size } ?: 0  // Cuenta todos los items en todas las categorías
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        var currentItemIndex = position
        var foundItem: MenuItem? = null

        // Recorremos las categorías hasta encontrar el item correspondiente
        dataset?.categories?.let { categories ->
            for (category in categories) {
                if (currentItemIndex < category.items.size) {
                    foundItem = category.items[currentItemIndex]
                    break
                }
                currentItemIndex -= category.items.size
            }
        }

        // Ahora `foundItem` tiene el `MenuItem` correspondiente
        foundItem?.let { item ->
            holder.binding.textViewMenuItemName.text = context.getString(item.name)
            holder.binding.imageViewMenuItem.setImageResource(item.image)
            holder.binding.textViewMenuItemPrice.text = context.getString(R.string.price_format, item.price) // Asignar el precio

        }
    }

}