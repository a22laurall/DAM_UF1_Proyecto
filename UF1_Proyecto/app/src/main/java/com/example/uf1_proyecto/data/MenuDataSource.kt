package com.example.uf1_proyecto.data

import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.model.Menu
import com.example.uf1_proyecto.model.Category
import com.example.uf1_proyecto.model.MenuItem


class MenuDataSource {

    // Devuelve el menú para un restaurante específico basado en su ID
    fun LoadMenuForRestaurant(restaurantId: Int): Menu? {
        return when (restaurantId) {
            1 -> Menu(
                restaurantId = restaurantId,
                categories = listOf(
                    Category(
                        name = R.string.restaurant_bon_pe,
                        items = listOf(
                            MenuItem(R.string.menu_item_cesar_salad, 12.00, R.drawable.centolla),
                            MenuItem(R.string.menu_item_bruschetta, 14.00, R.drawable.centolla)
                        )
                    ),
                    Category(
                        name = R.string.category_principales,
                        items = listOf(
                            MenuItem(R.string.menu_item_pasta_alfredo, 13.50, R.drawable.centolla),
                            MenuItem(R.string.menu_item_grilled_salmon, 13.50, R.drawable.centolla)
                        )
                    ),
                    Category(
                        name = R.string.category_postres,
                        items = listOf(
                            MenuItem(R.string.menu_item_tiramisu, 4.50, R.drawable.centolla),
                            MenuItem(R.string.menu_item_panna_cotta,3.50, R.drawable.centolla)
                        )
                    )
                )
            )
            2 -> Menu(
                restaurantId = restaurantId,
                categories = listOf(
                    Category(
                        name = R.string.category_entrantes,
                        items = listOf(
                            MenuItem(R.string.menu_item_edamame, 4.50, R.drawable.centolla),
                            MenuItem(R.string.menu_item_miso_soup, 5.00, R.drawable.centolla)
                        )
                    ),
                    Category(
                        name = R.string.category_principales,
                        items = listOf(
                            MenuItem(R.string.menu_item_ramen_bowl, 13.50, R.drawable.centolla),
                            MenuItem(R.string.menu_item_sushi_platter, 15.50, R.drawable.centolla)
                        )
                    ),
                    Category(
                        name = R.string.category_postres,
                        items = listOf(
                            MenuItem(R.string.menu_item_mochi_ice_cream, 3.50, R.drawable.centolla),
                            MenuItem(R.string.menu_item_matcha_cheesecake,4.50, R.drawable.centolla)
                        )
                    )
                )
            )
            else -> null // Si no hay menú asociado con el ID
        }
    }

    // Devuelve una lista con todos los menús para todos los restaurantes
//    fun LoadAllMenus(): List<Menu> {
//        return listOfNotNull(
//            LoadMenuForRestaurant(1),
//            LoadMenuForRestaurant(2),
//            // Agrega más restaurantes según sea necesario
//        )
//    }
}
