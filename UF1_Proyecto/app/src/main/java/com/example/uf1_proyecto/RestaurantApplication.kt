package com.example.uf1_proyecto

import android.app.Application
import com.example.uf1_proyecto.data.Category
import com.example.uf1_proyecto.data.JsonUtil
import com.example.uf1_proyecto.data.Menu
import com.example.uf1_proyecto.data.MenuItem
import com.example.uf1_proyecto.data.Restaurant
import com.example.uf1_proyecto.data.app.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RestaurantApplication : Application() {

    val database by lazy { AppDatabase.getDatabase(this) }

    override fun onCreate() {
        super.onCreate()
        initDb()
    }

    private fun initDb() {
        deleteDatabase("restaurant_database")


        val restaurantDao = database.restaurantDao()
        val menuDao = database.menuDao()
        val categoryDao = database.categoryDao()
        val menuItemDao = database.menuItemDao()

        CoroutineScope(Dispatchers.IO).launch {
            if (restaurantDao.getCount() == 0) { // Inserta solo si no hay datos
                val restaurantes = JsonUtil.leerJsonDesdeRaw<Restaurant>(this@RestaurantApplication, R.raw.restaurants)
                for (restaurant in restaurantes){
                    restaurantDao.insertRestaurant(restaurant)
                }

            }

            if (menuDao.getCount() == 0) {
                val menus = JsonUtil.leerJsonDesdeRaw<Menu>(this@RestaurantApplication, R.raw.menus)
                for (menu in menus){
                    menuDao.insertMenu(menu)
                }
            }

            if (categoryDao.getCount() == 0) {
                val categorias = JsonUtil.leerJsonDesdeRaw<Category>(this@RestaurantApplication, R.raw.category)
                for (category in categorias){
                    categoryDao.insertCategory(category)
                }
            }

            if (menuItemDao.getCount() == 0) {
                val menuItems = JsonUtil.leerJsonDesdeRaw<MenuItem>(this@RestaurantApplication, R.raw.menu_items)
                for (item in menuItems){
                    menuItemDao.insertMenuItem(item)
                }
            }


        }
    }
}