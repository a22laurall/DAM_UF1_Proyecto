package com.example.uf1_proyecto.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant")
data class Restaurant (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "img") val img: String,
    @ColumnInfo(name = "imgLogo") val imgLogo: String,
    @ColumnInfo(name = "phoneNumber") val telefono: Int,
    @ColumnInfo(name = "direction") val direction: String
)