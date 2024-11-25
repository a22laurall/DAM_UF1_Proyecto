package com.example.uf1_proyecto.data

import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.model.Menu
import com.example.uf1_proyecto.model.Category
import com.example.uf1_proyecto.model.MenuItem

class MenuDataSource {

    // Devuelve el menú para un restaurante específico basado en su ID
    fun loadMenuForRestaurant(restaurantId: Int): Menu? {
        return when (restaurantId) {
            1 -> Menu(
                restaurantId = restaurantId,
                categories = listOf(
                    Category(
                        name = "Appetizers",
                        items = listOf(
                            MenuItem("Caesar Salad", 12.00, R.drawable.centolla),
                            MenuItem("Bruschetta", 14.00, R.drawable.centolla)
                        )
                    ),
                    Category(
                        name = "Main Course",
                        items = listOf(
                            MenuItem("Pasta Alfredo", 13.50, R.drawable.centolla),
                            MenuItem("Grilled Salmon", 13.50, R.drawable.centolla)
                        )
                    ),
                    Category(
                        name = "Desserts",
                        items = listOf(
                            MenuItem("Tiramisu", 4.50, R.drawable.centolla),
                            MenuItem("Panna Cotta",3.50, R.drawable.centolla)
                        )
                    )
                )
            )
            2 -> Menu(
                restaurantId = restaurantId,
                categories = listOf(
                    Category(
                        name = "Appetizers",
                        items = listOf(
                            MenuItem("Edamame", 4.50, R.drawable.centolla),
                            MenuItem("Miso Soup", 5.00, R.drawable.centolla)
                        )
                    ),
                    Category(
                        name = "Main Course",
                        items = listOf(
                            MenuItem("Ramen Bowl", 13.50, R.drawable.centolla),
                            MenuItem("Sushi Platter", 15.50, R.drawable.centolla)
                        )
                    ),
                    Category(
                        name = "Desserts",
                        items = listOf(
                            MenuItem("Mochi Ice Cream", 3.50, R.drawable.centolla),
                            MenuItem("Matcha Cheesecake",4.50, R.drawable.centolla)
                        )
                    )
                )
            )
            else -> null // Si no hay menú asociado con el ID
        }
    }

    // Devuelve una lista con todos los menús para todos los restaurantes
    fun loadAllMenus(): List<Menu> {
        return listOfNotNull(
            loadMenuForRestaurant(1),
            loadMenuForRestaurant(2),
            // Agrega más restaurantes según sea necesario
        )
    }
}
