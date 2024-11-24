package com.example.uf1_proyecto.data

import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.model.Restaurant

class DataSource {
    fun LoadAffirmation() : List<Restaurant> {
        return listOf<Restaurant>(
            Restaurant(R.string.restaurant_bon_pe, R.drawable.bonpe_7208),
            Restaurant(R.string.restaurant_leira_antiga, R.drawable.bonpe_7208),
            Restaurant(R.string.restaurant_kilowatio, R.drawable.bonpe_7208),
            Restaurant(R.string.restaurant_o_meson, R.drawable.bonpe_7208),
            Restaurant(R.string.restaurant_vilavella, R.drawable.bonpe_7208),
            Restaurant(R.string.restaurant_os_cantis, R.drawable.bonpe_7208),
            Restaurant(R.string.restaurant_os_cantis, R.drawable.bonpe_7208),
            Restaurant(R.string.restaurant_os_cantis, R.drawable.bonpe_7208),
            Restaurant(R.string.restaurant_os_cantis, R.drawable.bonpe_7208),
            Restaurant(R.string.restaurant_os_cantis, R.drawable.bonpe_7208),
            Restaurant(R.string.restaurant_os_cantis, R.drawable.bonpe_7208),
            Restaurant(R.string.restaurant_os_cantis, R.drawable.bonpe_7208),
            Restaurant(R.string.restaurant_os_cantis, R.drawable.bonpe_7208),
            Restaurant(R.string.restaurant_os_cantis, R.drawable.bonpe_7208),
            Restaurant(R.string.restaurant_os_cantis, R.drawable.bonpe_7208),
        )
    }
}