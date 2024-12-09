package com.example.uf1_proyecto.data.repository

import com.example.uf1_proyecto.data.entity.Category
import com.example.uf1_proyecto.data.entity.CategoryWithMenuItems
import com.example.uf1_proyecto.data.dao.CategoryDao

class CategoryRepository(private val categoryDao: CategoryDao) {
    suspend fun insertCategory(category: Category) {
        return categoryDao.insertCategory(category)
    }

    suspend fun deleteCategory(category: Category) {
        categoryDao.deleteCategory(category)
    }

    suspend fun updateCategory(category: Category) {
        categoryDao.updateCategory(category)
    }

    suspend fun getCategoryWithMenuItems(categoryId: Int): CategoryWithMenuItems {
        return categoryDao.getCategoryWithMenuItems(categoryId)
    }

    suspend fun getCategoriesByMenuId(menuId: Int): List<Category> {
        return categoryDao.getCategoriesByMenuId(menuId)
    }

    suspend fun getCount(): Int{
        return categoryDao.getCount();
    }
}