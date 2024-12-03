package com.example.uf1_proyecto.data

import androidx.room.Embedded
import androidx.room.Relation

data class RestaurantWithMenu(
    @Embedded val restaurant: Restaurant,
    @Relation(
        parentColumn = "id",
        entityColumn = "restaurantId"
    )
    val menu: Menu
)