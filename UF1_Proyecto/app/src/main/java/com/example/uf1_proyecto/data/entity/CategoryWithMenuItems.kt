package com.example.uf1_proyecto.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryWithMenuItems(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "id",
        entityColumn = "categoryId"
    )
    val items: List<MenuItem>
)
