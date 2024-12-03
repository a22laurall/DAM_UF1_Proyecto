package com.example.uf1_proyecto.data.dao

import androidx.room.*
import com.example.uf1_proyecto.data.Menu
import com.example.uf1_proyecto.data.MenuWithCategories

@Dao
interface MenuDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMenu(menu: Menu)

    @Update
    suspend fun updateMenu(menu: Menu)

    @Delete
    suspend fun deleteMenu(menu: Menu)

    @Transaction
    @Query("SELECT * FROM Menu WHERE id = :menuId")
    suspend fun getMenuWithCategories(menuId: Int): MenuWithCategories

    @Query("SELECT COUNT(*) FROM menu")
    suspend fun getCount(): Int
}