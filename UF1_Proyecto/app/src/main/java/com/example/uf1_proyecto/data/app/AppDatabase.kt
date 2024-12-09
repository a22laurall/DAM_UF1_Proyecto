package com.example.uf1_proyecto.data.app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.uf1_proyecto.data.entity.Category
import com.example.uf1_proyecto.data.entity.Menu
import com.example.uf1_proyecto.data.entity.MenuItem
import com.example.uf1_proyecto.data.entity.Restaurant
import com.example.uf1_proyecto.data.dao.CategoryDao
import com.example.uf1_proyecto.data.dao.MenuDao
import com.example.uf1_proyecto.data.dao.MenuItemDao
import com.example.uf1_proyecto.data.dao.RestaurantDao

@Database(
    entities = [Restaurant::class, Menu::class, Category::class, MenuItem::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao
    abstract fun menuDao(): MenuDao
    abstract fun categoryDao(): CategoryDao
    abstract fun menuItemDao(): MenuItemDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
             if (instance == null) {
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "restaurant_database"
                        ).build()
                    }
                    return instance!!
        }
    }
}
