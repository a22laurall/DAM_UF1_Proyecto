package com.example.uf1_proyecto.data.app

import android.content.Context
import com.example.uf1_proyecto.data.repository.CategoryRepository
import com.example.uf1_proyecto.data.repository.MenuItemRepository
import com.example.uf1_proyecto.data.repository.MenuRepository
import com.example.uf1_proyecto.data.repository.RestaurantRespository

/**
 * AppContainer es responsable de proporcionar instancias de repositorios para la aplicación.
 */
internal class AppContainer (context: Context) {

    // Instancia de la base de datos
    private val database: AppDatabase by lazy {
        AppDatabase.getDatabase(context)
    }

    // Repositorio para los restaurantes
    val restaurantRepository: RestaurantRespository by lazy {
        RestaurantRespository(database.restaurantDao())
    }

    val menuRepository: MenuRepository by lazy {
        MenuRepository(database.menuDao())
    }

    val categoryRepository: CategoryRepository by lazy {
        CategoryRepository(database.categoryDao())
    }

    val menuItemRepository: MenuItemRepository by lazy {
        MenuItemRepository(database.menuItemDao())
    }

}
