package com.example.uf1_proyecto.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MenuItem (
    @StringRes val name: Int,
    val price: Double,
    @DrawableRes val image: Int
)