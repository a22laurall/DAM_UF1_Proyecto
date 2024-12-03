package com.example.uf1_proyecto.data

import androidx.room.Embedded
import androidx.room.Relation

data class MenuWithCategories (
    @Embedded val menu: Menu,
    @Relation(
        parentColumn = "id",
        entityColumn = "menuId"
    )
    val categories: List<Category>
)