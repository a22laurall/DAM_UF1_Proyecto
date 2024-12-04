package com.example.uf1_proyecto.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.uf1_proyecto.entity.Restaurant
import com.example.uf1_proyecto.data.repository.RestaurantRespository
import com.example.uf1_proyecto.entity.RestaurantWithMenu

class RestaurantViewModel(private val restaurantRepository: RestaurantRespository) : ViewModel() {

    // LiveData para obtener todos los restaurantes
    val allRestaurants: LiveData<List<Restaurant>> = restaurantRepository.getAllRestaurants()

    // LiveData para obtener un restaurante específico con su menú
    fun getRestaurantWithMenu(restaurantId: Int): LiveData<RestaurantWithMenu> {
        return restaurantRepository.getRestaurantWithMenu(restaurantId)
    }

    fun getRestaurantById(restaurantId: Int): LiveData<Restaurant> {
        return restaurantRepository.getRestaurantById(restaurantId)
    }

    suspend fun insertRestaurant(restaurant: Restaurant) {
        restaurantRepository.insertRestaurant(restaurant)
    }

    suspend fun deleteRestaurant(restaurant: Restaurant) {
        restaurantRepository.deleteRestaurant(restaurant)
    }

    suspend fun updateRestaurant(restaurant: Restaurant) {
        restaurantRepository.updateRestaurant(restaurant)
    }
}

