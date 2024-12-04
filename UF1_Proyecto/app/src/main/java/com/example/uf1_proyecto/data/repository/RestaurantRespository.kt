package com.example.uf1_proyecto.data.repository

import androidx.lifecycle.LiveData
import com.example.uf1_proyecto.entity.Restaurant
import com.example.uf1_proyecto.entity.RestaurantWithMenu
import com.example.uf1_proyecto.data.dao.RestaurantDao


class RestaurantRespository(private val itemDao: RestaurantDao) {

    fun getRestaurantWithMenu(id: Int): LiveData<RestaurantWithMenu> {
        return itemDao.getRestaurantWithMenu(id)
    }

    fun getAllRestaurants(): LiveData<List<Restaurant>>{
        return itemDao.getAllRestaurants()
    }

    fun getRestaurantById(id: Int): LiveData<Restaurant>{
        return itemDao.getRestaurantById(id)
    }

    suspend fun insertRestaurant(restaurant: Restaurant) {
        return itemDao.insertRestaurant(restaurant)
    }

    suspend fun deleteRestaurant(restaurant: Restaurant) {
        return itemDao.deleteRestaurant(restaurant)
    }

    suspend fun updateRestaurant(restaurant: Restaurant) {
        return itemDao.updateRestaurant(restaurant)
    }

    suspend fun getCount(): Int{
        return itemDao.getCount()
    }
}