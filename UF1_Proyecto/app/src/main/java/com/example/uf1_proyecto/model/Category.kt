package com.example.uf1_proyecto.model

import androidx.annotation.StringRes

data class Category (
    @StringRes val name: Int,
    val items: List<MenuItem>
)