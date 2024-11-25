package com.example.uf1_proyecto.data

import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.model.Restaurant

class DataSource {
    fun LoadRestaurant() : List<Restaurant> {
        return listOf<Restaurant>(
            Restaurant( R.string.restaurant_bon_pe, R.drawable.bonpe_7208),
            Restaurant( R.string.restaurant_leira_antiga, R.drawable.bonpe_7208),
            Restaurant( R.string.restaurant_kilowatio, R.drawable.bonpe_7208),
            Restaurant( R.string.restaurant_o_meson, R.drawable.bonpe_7208),
            Restaurant( R.string.restaurant_vilavella, R.drawable.bonpe_7208),
            Restaurant( R.string.restaurant_os_cantis, R.drawable.bonpe_7208)
        )
    }

    fun LoadRestaurantForId(id: Int) : Restaurant? {

         when (id) {
            1 -> return Restaurant( R.string.restaurant_bon_pe, R.drawable.bonpe_7208)
            2 -> return Restaurant( R.string.restaurant_leira_antiga, R.drawable.bonpe_7208)
            3 -> return Restaurant( R.string.restaurant_kilowatio, R.drawable.bonpe_7208)
            4 -> return Restaurant( R.string.restaurant_o_meson, R.drawable.bonpe_7208)
            5 -> return Restaurant( R.string.restaurant_vilavella, R.drawable.bonpe_7208)
            6 -> return Restaurant( R.string.restaurant_os_cantis, R.drawable.bonpe_7208)
            else -> {
                return null
            }
        }
    }
}