package com.example.uf1_proyecto.data.repository

import com.example.uf1_proyecto.entity.Menu
import com.example.uf1_proyecto.entity.MenuWithCategories
import com.example.uf1_proyecto.data.dao.MenuDao

class MenuRepository(private val menuDao: MenuDao) {

    suspend fun insertMenu(menu: Menu) {
        menuDao.insertMenu(menu)
    }

    suspend fun deleteMenu(menu: Menu) {
        menuDao.deleteMenu(menu)
    }

    suspend fun updateMenu(menu: Menu) {
        menuDao.updateMenu(menu)
    }

    suspend fun getMenuWithCategories(menuId: Int): MenuWithCategories {
       return menuDao.getMenuWithCategories(menuId)
    }

    suspend fun getCount(): Int {
        return menuDao.getCount();
    }
}
