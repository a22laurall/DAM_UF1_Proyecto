package com.example.uf1_proyecto.data.repository

import com.example.uf1_proyecto.entity.MenuItem
import com.example.uf1_proyecto.data.dao.MenuItemDao

class MenuItemRepository(private val menuItemDao: MenuItemDao) {
    suspend fun insertMenuItem(menuItem: MenuItem) {
        return menuItemDao.insertMenuItem(menuItem)
    }

    suspend fun deleteMenuItem(menuItem: MenuItem) {
        return menuItemDao.deleteMenuItem(menuItem)
    }

    suspend fun updateMenuItem(menuItem: MenuItem) {
        return menuItemDao.updateMenuItem(menuItem)
    }

    suspend fun getCount(): Int{
        return menuItemDao.getCount();
    }
}