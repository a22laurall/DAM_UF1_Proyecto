package com.example.uf1_proyecto.model

import androidx.annotation.DrawableRes

data class MenuItem (
    val name: String,
    val price: Double,
    @DrawableRes val image: Int
)