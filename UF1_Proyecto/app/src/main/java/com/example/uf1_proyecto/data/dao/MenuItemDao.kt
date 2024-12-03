package com.example.uf1_proyecto.data.dao

import androidx.room.*
import com.example.uf1_proyecto.data.MenuItem

@Dao
interface MenuItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMenuItem(menuItem: MenuItem)

    @Update
    suspend fun updateMenuItem(menuItem: MenuItem)

    @Delete
    suspend fun deleteMenuItem(menuItem: MenuItem)

    @Query("SELECT COUNT(*) FROM menuitem")
    suspend fun getCount(): Int
}
