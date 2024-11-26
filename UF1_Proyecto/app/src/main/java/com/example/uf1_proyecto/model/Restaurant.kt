package com.example.uf1_proyecto.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Restaurant (
    val id: Int,
    @StringRes val stringResourceId: Int,
    @DrawableRes val drawableResourceId: Int,
    //val menu: Menu
)