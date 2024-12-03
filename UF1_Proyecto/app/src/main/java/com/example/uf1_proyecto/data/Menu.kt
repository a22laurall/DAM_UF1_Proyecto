package com.example.uf1_proyecto.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "menu",
    foreignKeys = [
        ForeignKey(
            entity = Restaurant::class,
            parentColumns = ["id"],
            childColumns = ["restaurantId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Menu(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "restaurantId") val restaurantId: Int
)