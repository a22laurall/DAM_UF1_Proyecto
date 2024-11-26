package com.example.uf1_proyecto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.databinding.MenuItemViewBinding
import com.example.uf1_proyecto.model.Category
import com.example.uf1_proyecto.model.MenuItem

class MenuItemAdapter (
    private val context: Context,
    private val dataset: List<Category>
        ) : RecyclerView.Adapter<MenuItemAdapter.MenuItemViewHolder>(){
    class MenuItemViewHolder(val binding: MenuItemViewBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val binding = MenuItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.sumOf { it.items.size }  // Cuenta todos los items en todas las categorías
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        var currentItemIndex = position
        var foundItem: MenuItem? = null

        // Recorremos las categorías hasta encontrar el item correspondiente
        for (category in dataset) {
            if (currentItemIndex < category.items.size) {
                foundItem = category.items[currentItemIndex]
                break
            }
            currentItemIndex -= category.items.size  // Avanzamos al siguiente grupo de items
        }

        // Ahora `foundItem` tiene el `MenuItem` correspondiente
        if (foundItem != null) {
            holder.binding.textViewMenuItemName.text = context.getString(foundItem.name)
            holder.binding.imageViewMenuItem.setImageResource(foundItem.image)
        }
    }

}