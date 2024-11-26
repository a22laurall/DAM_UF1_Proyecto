package com.example.uf1_proyecto.data

import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.model.Restaurant

class DataSource {
    fun LoadRestaurant() : List<Restaurant> {
        return listOf<Restaurant>(
            Restaurant(1,  R.string.restaurant_bon_pe, R.drawable.bonpe_red),
            Restaurant( 2, R.string.restaurant_leira_antiga, R.drawable.bonpe_red),
            Restaurant( 3, R.string.restaurant_kilowatio, R.drawable.bonpe_red),
            Restaurant( 4, R.string.restaurant_o_meson, R.drawable.bonpe_red),
            Restaurant( 5, R.string.restaurant_vilavella, R.drawable.bonpe_red),
            Restaurant(6, R.string.restaurant_os_cantis, R.drawable.bonpe_red)
        )
    }

    fun LoadRestaurantForId(id: Int) : Restaurant {

         when (id) {
            1 -> return Restaurant(1,R.string.restaurant_bon_pe, R.drawable.bonpe_red)
            2 -> return Restaurant(2,R.string.restaurant_leira_antiga, R.drawable.bonpe_red)
            3 -> return Restaurant(3, R.string.restaurant_kilowatio, R.drawable.bonpe_red)
            4 -> return Restaurant(4, R.string.restaurant_o_meson, R.drawable.bonpe_red)
            5 -> return Restaurant(5, R.string.restaurant_vilavella, R.drawable.bonpe_red)
            6 -> return Restaurant(6, R.string.restaurant_os_cantis, R.drawable.bonpe_red)
             else -> throw IllegalArgumentException("Restaurant with ID $id not found")  // Lanza una excepción si no existe el restaurante

         }
    }
}