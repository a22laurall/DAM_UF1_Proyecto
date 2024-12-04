package com.example.uf1_proyecto.data.dao

import androidx.room.*
import com.example.uf1_proyecto.entity.Category
import com.example.uf1_proyecto.entity.CategoryWithMenuItems

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCategory(category: Category)

    @Update
    suspend fun updateCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)

    @Transaction
    @Query("SELECT * FROM Category WHERE id = :categoryId")
    suspend fun getCategoryWithMenuItems(categoryId: Int): CategoryWithMenuItems

    @Transaction
    @Query("SELECT * FROM category WHERE menuId = :menuId")
    suspend fun getCategoriesByMenuId(menuId: Int): List<Category>

    @Query("SELECT COUNT(*) FROM category")
    suspend fun getCount(): Int

}
