package com.example.uf1_proyecto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.model.Restaurant

class ItemAdapter (
    private val context: Context,
    private val dataset: List<Restaurant>,
    private val onITemClick: (Restaurant) -> Unit
        ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById<TextView>(R.id.tvText)
        val imageView: ImageView = view.findViewById(R.id.ivImage)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return ItemViewHolder(adapterView)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val view = dataset[position]
        holder.textView.text = context.resources.getString(view.stringResourceId)
        holder.imageView.setImageResource(view.drawableResourceId)

        // Configura el clic
        holder.itemView.setOnClickListener {
            onITemClick(view)
        }
    }

}
